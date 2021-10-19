/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectz.rest;

import com.mycompany.projectz.config.ConnectionFactory;
import com.mycompany.projectz.daos.CategoryDao;
import com.mycompany.projectz.models.Category;
import com.mycompany.projectz.services.CategoryService;
import com.mycompany.projectz.services.ICategoryService;
import com.sun.jersey.api.client.ClientResponse;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author juandre
 */
@Path("category")
public class CategoryRestService {
    private final ICategoryService categoryService;

    public CategoryRestService(){
        this.categoryService = new CategoryService(new CategoryDao(ConnectionFactory.getInstance()));
    }

    @GET
    @Path("/getAllCategories")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getAll(){
        return categoryService.getAll();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getById(@PathParam("id")int id){
        return categoryService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCategory(Category category){
        return categoryService.addCategory(category) ? Response.status(Status.CREATED).build() : Response.status(Status.NOT_ACCEPTABLE).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCategory(Category category){
        return categoryService.updateCategory(category) ? Response.status(Status.CREATED).build() : Response.status(Status.NOT_ACCEPTABLE).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCategory(@PathParam("id") int id){
        return categoryService.deleteCategory(id) ? Response.status(Status.OK).build() : Response.status(Status.NOT_ACCEPTABLE).build();
    }
}
