package com.coronaUpdates.demo.models;



import com.coronaUpdates.demo.CoronaArchiveFetchingData;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value="value", method = RequestMethod.GET)
public class homeController {
@Autowired
  CoronaArchiveFetchingData coronaArchiveFetchingData;

    @GetMapping("/values")
    public String values(@RequestParam(value="a", required=false, defaultValue="") String value, @NotNull Model model) {
        model.addAttribute("a", value);
       model.addAttribute("locationStats", coronaArchiveFetchingData.getList());

        return "values";
    }

}
