package com.project.ippaitu.controller;

import com.project.ippaitu.model.Event;
import com.project.ippaitu.service.EventService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EventController {

    private EventService eventService;
    public EventController(EventService eventService){
        super();
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String homePage(Model model){
        List<Event> listevent = eventService.getlistAll();
        model.addAttribute("listevent",listevent);
        System.out.println("Get /");
        return "index";
    }
    @GetMapping("/new")
    public String add(Model model){
        model.addAttribute("event",new Event());
        return "new";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveEvent(@ModelAttribute("event")Event event){
        eventService.save(event);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id")int id){
        ModelAndView mav = new ModelAndView("new");
        Event event = eventService.get(id);
        mav.addObject("event",event);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        eventService.delete(id);
        return "redirect:/";
    }
}
