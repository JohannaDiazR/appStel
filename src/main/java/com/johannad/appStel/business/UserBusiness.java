package com.johannad.appStel.business;

import com.johannad.appStel.dtos.RoleDto;
import com.johannad.appStel.dtos.UserDto;
import com.johannad.appStel.entity.Role;
import com.johannad.appStel.entity.User;
import com.johannad.appStel.service.RoleService;
import com.johannad.appStel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserBusiness {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    private List<User> userList;

    public List<UserDto> findAll() throws Exception {
        this.userList=this.userService.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        this.userList.forEach(user -> {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());

            Role role = user.getRole();
            if (role != null){
                RoleDto roleDto = new RoleDto();
                roleDto.setId(role.getId());
                roleDto.setNombreRol(role.getNombreRol());
                userDto.setRole(roleDto);
            }
            userDto.setUsuario(user.getUsuario());
            userDto.setContrasena(user.getContrasena());
            userDtoList.add(userDto);
        });
        return userDtoList;
    }
    //POST
    public UserDto create(UserDto userDto) throws Exception {
        User user = new User();
        user.setUsuario(userDto.getUsuario());
        user.setContrasena(userDto.getContrasena());

        RoleDto roleDto = userDto.getRole();
        if (roleDto != null) {
            Role role = new Role();
            role.setId(roleDto.getId());
            role.setNombreRol(roleDto.getNombreRol());
            user.setRole(role);
        }
        User createdUser = userService.create(user);
        UserDto createdUserDto = new UserDto();
        createdUserDto.setId(createdUser.getId());
        createdUserDto.setUsuario(createdUser.getUsuario());
        createdUserDto.setContrasena(createdUser.getContrasena());

        Role role = createdUser.getRole();
        if (role != null) {
            roleDto.setId(role.getId());
            roleDto.setNombreRol(role.getNombreRol());
            createdUserDto.setRole(roleDto);
        }
        return createdUserDto;
    }

    //PUT
    public  void update(UserDto userDto, int id) throws Exception {
        User existingUser = userService.findById(id);
        if (existingUser == null) {
            throw new Exception("User not found");
        }
        existingUser.setUsuario(userDto.getUsuario());
        existingUser.setContrasena(userDto.getContrasena());

        RoleDto roleDto = userDto.getRole();
        if (roleDto != null) {
            Role existingRole = existingUser.getRole();
            if (existingRole == null){
                existingRole = new Role();
            }
            existingRole.setId(roleDto.getId());
            existingRole.setNombreRol(roleDto.getNombreRol());

            existingUser.setRole(existingRole);
        }
        userService.update(existingUser);
    }

}