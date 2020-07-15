package sample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sample.entity.MyData;
import sample.repositories.MyDataRepository;

@Controller
public class IndexController {

    // リポジトリを使う準備
    @Autowired
    MyDataRepository repository;

    @GetMapping("/")
    public String index() {
        // home.htmlを表示する
        return "home";
    }

    /**
     * ここでは thymeleaf を使って Web ページを表示させてみる
     *
     * @param model ビューに渡すデータを格納するオブジェクト
     */
    @GetMapping("/html")
    public String htmlIndex(Model model) {
        // モデルに対して値をセットしてみる
        model.addAttribute("test", "テスト表示");
        // resources/templates ディレクトリ配下の html ファイルが呼び出される
        return "index";
    }

    @PostMapping("/html")
    public String htmlPostIndex(RedirectAttributes redirectAttributes,
            @RequestParam("test1") String test1,
            @RequestParam(value = "test2", required = false) String test2,
            @RequestParam(value = "submit1", required = false) String submit1,
            @RequestParam(value = "submit2", required = false) String submit2,
            Model model) {
        model.addAttribute("test", "Postされたんだな");
        model.addAttribute("test1", test1);
        model.addAttribute("test2_text", test2);
        if (submit1 != null) {
            // 同じテンプレを使うけど、バインドする値が異なる
            return "index";
        }
        // こっちは submit2 を押した方
        // リダイレクトなので model にセットした値は使われない
        redirectAttributes.addFlashAttribute("test1", "リダイレクトした");
        return "redirect:/html";

    }

    @GetMapping("/repo")
    public String repoTest(@ModelAttribute("formModel") MyData mydata, Model model) {
        Iterable<MyData> list = repository.findAll();
        model.addAttribute("data", list);
        return "repo";
    }

    @PostMapping("/repo")
    public String repoPostTest(@ModelAttribute("formModel") MyData mydata, Model model) {
        repository.saveAndFlush(mydata);
        return "redirect:/repo";
    }
}
