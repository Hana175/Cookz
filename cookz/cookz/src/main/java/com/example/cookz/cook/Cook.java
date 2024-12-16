package com.example.cookz.cook;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.util.Objects;

//not empty is a form of validation
public class Cook {
    @Id //we're marking this as an id
     int id;
     @NotEmpty //name is not to be empty
     String name;
     String description;
     String ingredients;
     String instructions;
     String category;
     String image;
     @Version //we're making sure that when the object is updated, the version is updated as well.
     Integer version;



    // custom constraints.. validating things using a constructor.. example.
    public Cook(int id, String name, String description, String ingredients, String instructions, String category,
            String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.category = category;
        this.image = image;
        // custom constraints.. validating things using a constructor.. example.
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Recipe must have a name");
        }

    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public String getIngredients() {
//        return ingredients;
//    }
//
//    public String getInstructions() {
//        return instructions;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public String getImage() {
//        return image;
//    }
    // validation .. create validation API
    // go for dependencies.

//    @Override
//
//    public boolean equals(Object o) {
//        if (o == this) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        if (!(o instanceof Cook)) {
//            return false;
//        }
//        Cook c = (Cook) o;
//        return Objects.equals(id, c.id) && Objects.equals(name, c.name) && Objects.equals(description, c.description)
//                && Objects.equals(ingredients, c.ingredients) && Objects.equals(instructions, c.instructions)
//                && Objects.equals(category, c.category) && Objects.equals(image, c.image);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, description, ingredients, instructions, category, image);
//    }
//
//    @Override
//
//    public String toString() {
//        return "Cook{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\''
//                + ", ingredients='" + ingredients + '\'' + ", instructions='" + instructions + '\'' + ", category='"
//                + category + '\'' + ", image='" + image + '\'' + '}';
//    }
}
