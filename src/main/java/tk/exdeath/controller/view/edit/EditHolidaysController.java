package tk.exdeath.controller.view.edit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.model.Holiday;
import tk.exdeath.model.User;
import tk.exdeath.model.service.UserService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Controller
public class EditHolidaysController {

    String userLogin;
    User user;
    UserService userService = new UserService();


    @GetMapping("/editHolidays")
    public String edit(
            @RequestParam String userLogin, Model model) {

        this.userLogin = userLogin;
        this.user = userService.readUserByLogin(userLogin);

        model.addAttribute("userLogin", userLogin);
        model.addAttribute("holidays", user.getHolidays());
        return "edit/editHolidays";
    }


    @PostMapping("/editHolidays")
    public String editHolidays(
            @RequestParam int beginYear,
            @RequestParam int beginMonth,
            @RequestParam int beginDay,
            @RequestParam int endYear,
            @RequestParam int endMonth,
            @RequestParam int endDay, Model model) {

        LocalDate beginDate = LocalDate.of(beginYear, beginMonth, beginDay);
        LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);

        int length = (int)ChronoUnit.DAYS.between(beginDate, endDate);

        Holiday holiday = new Holiday(length, beginYear, beginMonth, beginDay, user);
        user.addHoliday(holiday);
        userService.update(user);

        model.addAttribute("userLogin", userLogin);
        model.addAttribute("holidays", user.getHolidays());
        return "edit/editHolidays";
    }

}
