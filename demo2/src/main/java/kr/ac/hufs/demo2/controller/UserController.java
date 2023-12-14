package kr.ac.hufs.demo2.controller;

import kr.ac.hufs.demo2.domain.Member;
import kr.ac.hufs.demo2.dto.PostUserRequest;
import kr.ac.hufs.demo2.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    final MemberService memberService;

    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData) {
        System.out.println("Test Post");
        log.info("Test Post");
        requestData.entrySet().forEach(stringObjectEntry -> {
            System.out.println("key : " + stringObjectEntry.getKey()
            + " " +"value : " + stringObjectEntry.getValue());
        });

    }

    @PostMapping()
    public void postObject(@RequestBody PostUserRequest postUserRequest) {
        System.out.println(postUserRequest.toString());
        memberService.registerMember(postUserRequest);
    }

    @PutMapping("/put")
    public void put(@RequestBody Map<String, Object> requestData) {
        requestData.entrySet().forEach(stringObjectEntry -> {
            System.out.println("key : " + stringObjectEntry.getKey()
                    + " " +"value : " + stringObjectEntry.getValue());
        });

    }

    @PutMapping()
    public void putObject(@RequestBody PostUserRequest postUserRequest) {
        System.out.println(postUserRequest.toString());
        memberService.modifyMember(postUserRequest);
    }

    @PutMapping("/put-object-entity")
    public ResponseEntity<PostUserRequest> pubObjectEntity(@RequestBody PostUserRequest postUserRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postUserRequest);

    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable String userId, @RequestParam String email) {
        System.out.println(userId);
        System.out.println(email);
        memberService.deleteMember(Long.valueOf(userId), email);

    }

    @GetMapping("/get")
    public PostUserRequest get() {
        PostUserRequest user = new PostUserRequest();

        user.setName("tester");

        return user;
    }

    @GetMapping("")
    public List<Member> getMembers() {
        List<Member> members = memberService.getMemberAll();

        return members;
    }

    @GetMapping("/{userId}")
    public  Member getMember(@PathVariable String userId,
                             @RequestParam String email) {
        return memberService.getMember(Long.valueOf(userId), email);

    }


}
