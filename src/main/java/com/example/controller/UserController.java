package com.example.controller;

import com.example.entitys.User;
import com.example.representatios.CreateUserDTO;
import com.example.representatios.UpdateUserDTO;
import com.example.service.UserService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    @Inject
    UserService userService;

    @POST
    @Transactional
    public User createUser(CreateUserDTO createUserDTO) {
        return userService.create(createUserDTO);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public User updateUser(@PathParam("id") Long id, UpdateUserDTO updateCreateUserDTO) {
        return userService.update(id, updateCreateUserDTO);
    }

    @GET
    public Response getAllTasks() {
        List<User> user = userService.getAllUsers();
        return Response.ok(user).build();
    }

    @GET
    @Path("/{id}")
    public User getUserById(@PathParam("id")Long id){
        return userService.getUserByid(id);
    }
    @DELETE
    @Path("/{id}")
    public Response deleteUserById(@PathParam("id")Long id){
       userService.deleteUserById(id);
        return Response.ok().build();

    }
}
