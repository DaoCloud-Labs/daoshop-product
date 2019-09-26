package io.daocloud.shop.product.controller;

import com.google.gson.Gson;
import io.daocloud.shop.product.entity.ApiResult;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/s1")
@Slf4j
public class DemoController {

    private static final Gson GSON = new Gson();

    @Value("${dmp.test.app.rate:80}")
    private int rate;

    @Value("${dmp.test.app.timeout:100}")
    private int timeout;

    public String content_1k = "this is 1k msg abcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghijklmnabcdefghi";
    public String content_20k = this.getContent_20k(content_1k);
    public String content_500k = this.getContent_500k(content_20k);
    public String content_1M = this.getContent_1M(content_500k);
    public String content_5M = this.getContent_5M(content_1M);

    public String getContent_20k(String content) {
        String re_content = "";
        int i;
        for (i = 0; i < 20; i++) {
            re_content = re_content + content;
        }
        return re_content;
    }

    public String getContent_500k(String content) {
        String re_content = "";
        int i;
        for (i = 0; i < 25; i++) {
            re_content = re_content + content;
        }
        return re_content;
    }

    public String getContent_1M(String content) {
        String re_content = "";
        int i;
        for (i = 0; i < 2; i++) {
            re_content = re_content + content;
        }
        return re_content;
    }

    public String getContent_5M(String content) {
        String re_content = "";
        int i;
        for (i = 0; i < 5; i++) {
            re_content = re_content + content;
        }
        return re_content;
    }

    //返回内容为1k的接口

    @GetMapping("/0ms/1k")
    public Mono<ApiResult> api0ms1k() {
        log.info("0ms/1k start " + System.currentTimeMillis());
        ApiResult apiResult = ApiResult.builder().code(200).message("0ms/1k").data(this.content_1k).build();
        log.info("0ms/1k end " + System.currentTimeMillis());
        return Mono.just(apiResult).delayElement(Duration.ofMillis(0));
    }

    @GetMapping("/200ms/1k")
    public Mono<ApiResult> api200ms1k() {
        log.info("200ms/1k start " + System.currentTimeMillis());
        ApiResult apiResult = ApiResult.builder().code(200).message("200ms/1k").data(this.content_1k).build();
        log.info("200ms/1k end " + System.currentTimeMillis());
        return Mono.just(apiResult).delayElement(Duration.ofMillis(200));
    }

    @GetMapping("/500ms/1k")
    public Mono<ApiResult> api500ms1k() {
        log.info("500ms/1k start " + System.currentTimeMillis());
        ApiResult apiResult = ApiResult.builder().code(200).message("500ms/1k").data(this.content_1k).build();
        log.info("500ms/1k end " + System.currentTimeMillis());
        return Mono.just(apiResult).delayElement(Duration.ofMillis(500));
    }

    @GetMapping("/1s/1k")
    public Mono<ApiResult> api1s1k() {
        ApiResult apiResult = ApiResult.builder().code(200).message("1s/1k").data(this.content_1k).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(1000));
    }

    @GetMapping("/2s/1k")
    public Mono<ApiResult> api2s1k() {
        ApiResult apiResult = ApiResult.builder().code(200).message("2s/1k").data(this.content_1k).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(2000));
    }

    @GetMapping("/5s/1k")
    public Mono<ApiResult> api3s1k() {
        ApiResult apiResult = ApiResult.builder().code(200).message("5s/1k").data(this.content_1k).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(5000));
    }

    //返回内容为20k的接口
    @GetMapping("/200ms/20k")
    public Mono<ApiResult> api200ms20k() {
        ApiResult apiResult = ApiResult.builder().code(200).message("200ms/20k").data(this.content_20k).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(200));
    }

    @GetMapping("/500ms/20k")
    public Mono<ApiResult> api500ms20k() {
        ApiResult apiResult = ApiResult.builder().code(200).message("500ms/20k").data(this.content_20k).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(500));
    }

    @GetMapping("/1s/20k")
    public Mono<ApiResult> api1s20k() {
        ApiResult apiResult = ApiResult.builder().code(200).message("1s/20k").data(this.content_20k).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(1000));
    }

    @GetMapping("/2s/20k")
    public Mono<ApiResult> api2s20k() {
        ApiResult apiResult = ApiResult.builder().code(200).message("2s/20k").data(this.content_20k).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(2000));
    }

    @GetMapping("/5s/20k")
    public Mono<ApiResult> api5s20k() {
        ApiResult apiResult = ApiResult.builder().code(200).message("5s/20k").data(this.content_20k).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(5000));
    }

    //返回内容为500k的接口
    @GetMapping("/200ms/500k")
    public Mono<ApiResult> api200ms500k() {
        ApiResult apiResult = ApiResult.builder().code(200).message("200ms/500k").data(this.content_500k).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(200));
    }

    @GetMapping("/500ms/500k")
    public Mono<ApiResult> api500ms500k() {
        ApiResult apiResult = ApiResult.builder().code(200).message("500ms/500k").data(this.content_500k).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(500));
    }

    @GetMapping("/1s/500k")
    public Mono<ApiResult> api1s500k() {
        ApiResult apiResult = ApiResult.builder().code(200).message("1s/500k").data(this.content_500k).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(1000));
    }

    @GetMapping("/2s/500k")
    public Mono<ApiResult> api2s500k() {
        ApiResult apiResult = ApiResult.builder().code(200).message("2s/500k").data(this.content_500k).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(2000));
    }

    @GetMapping("/5s/500k")
    public Mono<ApiResult> api5s500k() {
        ApiResult apiResult = ApiResult.builder().code(200).message("5s/500k").data(this.content_500k).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(5000));
    }

    //返回内容为1M的接口
    @GetMapping("/200ms/1M")
    public Mono<ApiResult> api200ms1M() {
        ApiResult apiResult = ApiResult.builder().code(200).message("200ms/1M").data(this.content_1M).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(200));
    }

    @GetMapping("/500ms/1M")
    public Mono<ApiResult> api500ms1M() {
        ApiResult apiResult = ApiResult.builder().code(200).message("500ms/1M").data(this.content_1M).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(500));
    }

    @GetMapping("/1s/1M")
    public Mono<ApiResult> api1s1M() {
        ApiResult apiResult = ApiResult.builder().code(200).message("1s/1M").data(this.content_1M).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(1000));
    }

    @GetMapping("/2s/1M")
    public Mono<ApiResult> api2s1M() {
        ApiResult apiResult = ApiResult.builder().code(200).message("2s/1M").data(this.content_1M).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(2000));
    }

    @GetMapping("/5s/1M")
    public Mono<ApiResult> api5s1M() {
        ApiResult apiResult = ApiResult.builder().code(200).message("5s/1M").data(this.content_1M).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(5000));
    }

    //返回内容为5M的接口
    @GetMapping("/200ms/5M")
    public Mono<ApiResult> api200ms5M() {
        ApiResult apiResult = ApiResult.builder().code(200).message("200ms/5M").data(this.content_5M).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(200));
    }

    @GetMapping("/500ms/5M")
    public Mono<ApiResult> api500ms5M() {
        ApiResult apiResult = ApiResult.builder().code(200).message("500ms/5M").data(this.content_5M).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(500));
    }

    @GetMapping("/1s/5M")
    public Mono<ApiResult> api1s5M() {
        ApiResult apiResult = ApiResult.builder().code(200).message("1s/5M").data(this.content_5M).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(1000));
    }

    @GetMapping("/2s/5M")
    public Mono<ApiResult> api2s5M() {
        ApiResult apiResult = ApiResult.builder().code(200).message("2s/5M").data(this.content_5M).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(2000));
    }

    @GetMapping("/5s/5M")
    public Mono<ApiResult> api5s5M() {
        ApiResult apiResult = ApiResult.builder().code(200).message("5s/5M").data(this.content_5M).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(5000));
    }

    @GetMapping("/sleep/1k")
    public Mono<ApiResult> sleepApi() {
        ApiResult apiResult = ApiResult.builder().code(200).message("sleep:" + timeout + "s/1k").data(this.content_1k).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(timeout));
    }

    @GetMapping("/sleep/{sleep}/1k")
    public Mono<ApiResult> sleepApi(@PathVariable("sleep") long sleep) throws Exception {
        ApiResult apiResult = ApiResult.builder().code(200).message("sleep:" + sleep + "s/5M").data(this.content_5M).build();
        return Mono.just(apiResult).delayElement(Duration.ofMillis(sleep));
    }

    @PutMapping("/put")
    public Mono<String> putMethod() {
        return Mono.just("put");
    }

    @DeleteMapping("delete")
    public Mono<String> delete() {
        return Mono.just("delete");
    }

    @PostMapping("/post")
    public Mono<String> post() {
        return Mono.just("post");
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
        RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "❌, 文件是空的。";
        }

        String location = System.getProperty("user.dir") + "/data/tmp";

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(location + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "👌，上传文件大小：" + file.getSize();
    }
}
