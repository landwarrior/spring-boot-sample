# spring-boot-sample
Spring Boot の勉強用

---

とりあえず準備したものは以下

### http://localhost:8080

アドレスを覚えるの面倒なのでジャンボトロンでも表示してそれぞれのリンクを載せることにしました。

### http://localhost:8080/hello

ハローワールド用。  
RestController なので、 HTTP ボディにそのまま文字列を入れてレスポンスとしているだけ。

### http://localhost:8080/html

thymeleaf を使った Web アプリケーションのサンプル。  
基本的な動作の確認用。

### http://localhost:8080/repo

H2 とかいう DB を使ったデータアクセスの確認用。  
インメモリーデータベースとして使用しているので実行している間しかデータが保持されない。  
登録と表示のみ対応。  
バリデートとか入れてないので、すぐエラーになる。
