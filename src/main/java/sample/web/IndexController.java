package sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {
        // とりあえずリダイレクトで RestController に飛ばしておく
		return "redirect:/hello";
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
}
