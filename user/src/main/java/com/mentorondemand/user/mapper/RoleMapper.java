package com.mentorondemand.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mentorondemand.user.domain.Role;
import com.mentorondemand.user.dto.RoleDTO;


@Mapper(componentModel = "spring", uses = {})
public interface RoleMapper {
 RoleDTO roleToROleDTO(Role role);
 List<RoleDTO> roleToRoleDTOs(List<Role> roles);
}
