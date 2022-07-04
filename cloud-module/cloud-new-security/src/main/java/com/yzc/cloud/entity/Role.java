package com.yzc.cloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Sanz
 * @since 2022-06-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Role implements Serializable, GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    private String roleName;

    private String state;

    @JsonIgnore
    @Override
    public String getAuthority() {
        return roleName;
    }
}
