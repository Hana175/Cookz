package com.example.cookz.cook;

import java.util.Objects;

import jakarta.validation.constraints.NotEmpty;

//not empty is a form of validation
public class Cook {
    private int id;
    @NotEmpty //name is not to be empty
    private String name;
    private String description;
    private String ingredients;
    private String instructions;
    private String category;
    private String image;

    //custom constraints.. validating things using a constructor.. example.
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
        if(name.isEmpty()){
            throw new IllegalArgumentException("Recipe must have a name");
        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }
    //validation .. create validation API
   //go for dependencies.

    @Override

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!(o instanceof Cook)) {
            return false;
        }
        Cook c = (Cook) o;
        return Objects.equals(id, c.id) && Objects.equals(name, c.name) && Objects.equals(description, c.description)
                && Objects.equals(ingredients, c.ingredients) && Objects.equals(instructions, c.instructions)
                && Objects.equals(category, c.category) && Objects.equals(image, c.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, ingredients, instructions, category, image);
    }

    @Override

    public String toString() {
        return "Cook{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\''
                + ", ingredients='" + ingredients + '\'' + ", instructions='" + instructions + '\'' + ", category='"
                + category + '\'' + ", image='" + image + '\'' + '}';
    }
}
