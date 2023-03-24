package sashoq.spring.springMVC.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sashoq.spring.springMVC.dao.CarDAO;
import sashoq.spring.springMVC.models.Car;

import javax.validation.Valid;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private final CarDAO carDao;
    @Autowired
    public CarsController(CarDAO carDao) {
        this.carDao = carDao;
    }

    @GetMapping()
    public String index(Model model){
    model.addAttribute("cars",carDao.index());
    return "cars/indexcars";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("car",carDao.show(id));
        return "cars/showcar";
    }
    @GetMapping("/new")
    public String newCar(@ModelAttribute("car") Car car){
        return "cars/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("car") @Valid Car car,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "cars/new";
        }
        carDao.save(car);
        return "redirect:/cars";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("car",carDao.show(id));
        return "cars/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("car") @Valid Car car, BindingResult bindingResult,@PathVariable("id") int id){
        if(bindingResult.hasErrors()){
            return "cars/edit";
        }
        carDao.update(car,id);
        return "redirect:/cars";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        carDao.delete(id);
        return "redirect:/cars";
    }
}
