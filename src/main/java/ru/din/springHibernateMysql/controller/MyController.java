package ru.din.springHibernateMysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.din.springHibernateMysql.model.SomeData;
import ru.din.springHibernateMysql.service.SomeDataService;


import java.util.List;

@Controller
public class MyController {

    private SomeDataService someDataService;
    private int page;

    @GetMapping("/")
    public ModelAndView mainPage(ModelAndView modelAndView) {
        List<SomeData> someData = someDataService.allData();
        modelAndView.setViewName("mainPage");
        modelAndView.addObject("someDataList", someData);
        return modelAndView;
    }

    /*@GetMapping("/")
    public ModelAndView allPeople(@RequestParam(defaultValue = "1") int page, ModelAndView modelAndView) {
        List<SomeData> someData = someDataService.allData(page);
        int peopleCount = someDataService.peopleCount();
        int pagesCount = (peopleCount + 9)/10;
        modelAndView.setViewName("mainPage");
        modelAndView.addObject("page", page);
        modelAndView.addObject("someData", someData);
        modelAndView.addObject("peopleCount", peopleCount);
        modelAndView.addObject("pagesCount", pagesCount);
        this.page = page;

        return modelAndView;
    }*/

    @GetMapping("/edit")
    public ModelAndView editPage(ModelAndView modelAndView) {
        modelAndView.setViewName("editPage");

        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") int id, ModelAndView modelAndView) {
        SomeData someData = someDataService.readById(id);
        modelAndView.setViewName("editPage");
        modelAndView.addObject("someData", someData);

        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editFilm(@ModelAttribute("someData") SomeData someData, ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:/?page=" + this.page);
        someDataService.update(someData);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addPage(ModelAndView modelAndView) {
        modelAndView.setViewName("editPage");

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addSomeData(@ModelAttribute("someData") SomeData someData, ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:/?page=" + this.page);
        modelAndView.setViewName("redirect:/");

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteData(@PathVariable("id") int id, ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:/?page=" + this.page);
        someDataService.delete(someDataService.readById(id));

        return modelAndView;
    }

    @Autowired
    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }
}