package tk.exdeath.controller.view.edit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.controller.view.LoggedUser;
import tk.exdeath.model.Holiday;
import tk.exdeath.model.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Controller
public class EditHolidaysController {

    String path;
    String login;
    User user;

    @GetMapping("/editHolidays")
    public String edit(Model model) {

        path = LoggedUser.getLanguage() + "/edit/editHolidays" + LoggedUser.getLanguage();
        login = LoggedUser.getLogin();
        user = LoggedUser.getUser();

        model.addAttribute("userLogin", login);
        model.addAttribute("holidays", user.getHolidays());
        return path;
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
        int length = (int) ChronoUnit.DAYS.between(beginDate, endDate);

        Holiday holiday = new Holiday(length, beginYear, beginMonth, beginDay, user);
        user.addHoliday(holiday);
        LoggedUser.getUserService().update(user);

        model.addAttribute("userLogin", login);
        model.addAttribute("holidays", user.getHolidays());
        return path;
    }
}
