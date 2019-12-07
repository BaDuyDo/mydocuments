package app4;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    int a = 12;
    String b = "khanh";

    @GetMapping("/profile")
    public String profile(Mo[]){
        Model model;
        // Tạo ra thông tin
        List<Info> profile = new ArrayList<>();
        profile.add(new Info("fullname", "Nguyễn Hoàng Nam"));
        profile.add(new Info("nickname", "lốddaf"));
        profile.add(new Info("gmail", "loda.namnh@gmail.com"));
        profile.add(new Info("facebook", "https://www.facebook.com/nam.tehee"));
        profile.add(new Info("website", "https://loda.me"));

        // Đưa thông tin vào Model
        model.addAttribute("lodaProfile", profile);
        model.addAttribute("diem", a);
        model.addAttribute("ten",b);
        
        // TRả về template profile.html
        return "profile";
    }
}