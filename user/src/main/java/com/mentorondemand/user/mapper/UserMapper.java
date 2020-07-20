package com.mentorondemand.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mentorondemand.user.domain.User;
import com.mentorondemand.user.domain.UserRoles;
import com.mentorondemand.user.dto.UserDTO;
import com.mentorondemand.user.dto.UserRolesDTO;


@Mapper(componentModel = "spring", uses = {})
public interface UserMapper {
User userDtoToUser(UserDTO user);
UserDTO usetToUserDto(User user);

UserRoles userRoleDtoToUserRole(UserRolesDTO userRoleDTO);
UserRolesDTO userRoleToUserRoleDto(UserRoles userRoleDTO);

List<UserRoles> userRoleDtoToUserRoles(List<UserRolesDTO> userRoleDTO);
List<UserRolesDTO> userRoleToUserRoleDtos(List<UserRoles> userRoleDTO);

}
