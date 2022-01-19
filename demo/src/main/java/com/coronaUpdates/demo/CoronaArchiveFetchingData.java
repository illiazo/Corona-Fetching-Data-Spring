package com.coronaUpdates.demo;

import com.CoronaArchiveProject.demo.controller.models.LocationState;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.xml.stream.Location;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaArchiveFetchingData {
    private List<LocationState> list = new ArrayList<>();
    private String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/01-01-2021.csv";
    @PostConstruct
    @Scheduled(cron = "* * * 1 * *")
    public void fetchData() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(VIRUS_DATA_URL)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        StringReader reader = new StringReader(response.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);

        for (CSVRecord record : records) {
            LocationState locationState = new LocationState();
            //FIPS,Admin2,Province_State,Country_Region,Last_Update,Lat,Long_,
            // Confirmed,Deaths,Recovered,Active,Combined_Key,Incident_Rate,Case_Fatality_Ratio
           /* String fips = record.get("FIPS");
            String admin2 = record.get("Admin2");
            String lat = record.get("Lat");
            String longg = record.get("Long_");
            String confirmed = record.get("Confirmed");
            String combinedKey = record.get("Combined_Key");
            String incidentRate = record.get("Incident_Rate");
            String caseFatalityRatio = record.get("Case_Fatality_Ratio");*/
            String lastUpdate = record.get("Last_Update");
            String country = record.get("Country_Region");
            String deaths = record.get("Deaths");
            String active = record.get("Active");
            String recovered = record.get("Recovered");
            String province = record.get("Province_State");
            try{ locationState.setState(province);
                locationState.setCountry(country);
                locationState.setLatestUpdate(record.get(record.size()-1));
                locationState.setActives(active);
                locationState.setDeaths(deaths);
                locationState.setRecovered(recovered);
                this.list.add(locationState);
                System.out.println(locationState.toString());}
            catch(NumberFormatException e){
                System.out.println("Error!");
            }
        }

    }

    public List<LocationState> getList() {
        return list;
    }
}
