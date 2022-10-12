package com.example.pucrhase.domain;

import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Member implements UserDetails {
    @Id
    String loginId;
    String password;
    String name;

    // 멤버 구분 ( 협력업체 / 내부 임직원 / 관리자 )
    MemberType memberType;

    String status;
    LocalDateTime regDate;
    LocalDateTime modDate;

    @Builder
    public Member(String loginId, String password, String name, MemberType memberType, LocalDateTime now) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.memberType = memberType;
        this.regDate = now;
    }
    @Builder
    public Member(String loginId, String password, String name, MemberType memberType, String status, LocalDateTime now) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.memberType = memberType;
        this.status = status;
        this.modDate = now;
    }
    public Member() {
    }


    public String getLoginId() {
        return loginId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("USER"));
        if(this.memberType==MemberType.ADMIN){
            grantedAuthorityList.add(new SimpleGrantedAuthority("ADMIN"));

        }

        return grantedAuthorityList;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.loginId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getName() {
        return name;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public LocalDateTime getModDate() {
        return modDate;
    }

}
