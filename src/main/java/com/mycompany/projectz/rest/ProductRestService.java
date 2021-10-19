/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectz.rest;

import com.mycompany.projectz.config.ConnectionFactory;
import com.mycompany.projectz.daos.ProductDao;
import com.mycompany.projectz.models.Product;
import com.mycompany.projectz.services.IProductService;
import com.mycompany.projectz.services.ProductService;
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
@Path("/product")
public class ProductRestService {
    private final IProductService productService;

    public ProductRestService(){
        this.productService = new ProductService(new ProductDao(ConnectionFactory.getInstance()));
    }

    @GET
    @Path("/getAllProducts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAll(){
        return this.productService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getById(@PathParam("id")int id){
        return this.productService.getById(id);
    }

    @GET
    @Path("/category/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getByCategoryId(@PathParam("id")int categoryId){
        return productService.getByCategoryId(categoryId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(Product product){
        return productService.addProduct(product) ? Response.status(Status.CREATED).build(): Response.status(Status.NOT_ACCEPTABLE).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(Product product){
        return productService.updateProduct(product) ? Response.status(Status.ACCEPTED).build(): Response.status(Status.NOT_ACCEPTABLE).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id")int id){
        return productService.deleteProduct(id) ? Response.status(Status.OK).build() : Response.status(Status.NOT_ACCEPTABLE).build();
    }
}
