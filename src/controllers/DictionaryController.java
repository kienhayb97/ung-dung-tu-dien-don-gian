package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/translate")
    public String translate(@RequestParam String englishWord, Model model) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "xin chào");
        dictionary.put("dog", "con cho");
        dictionary.put("computer", "may tinh");
        String vietnamseWord = dictionary.get(englishWord);
        if (vietnamseWord != null) {
            model.addAttribute("englishWord", englishWord);
            model.addAttribute("vietnamseWord", vietnamseWord);

        } else {
            vietnamseWord = "not Found";
            model.addAttribute("englishWord", englishWord);
            model.addAttribute("vietnamseWord", vietnamseWord);
        }
        return "dictionary";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
