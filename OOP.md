Object Oriented Programming Concept Questions

As you should know by now, there are 4 pillars of Object Oriented Programming.

********************
1. Encapsulation

- Is the privatization of data and methods to their respective class. This helps avoid the accidental tempering of data by other methods. Through the use of getters and setters these values can still be modified unless declared 'final'.

Example: {

    public class Main {
    
        public static void main(String[] args) { 
            Ball ball = new Ball();
            
            //Print ball.colour failure:
            System.out.println(ball.colour);
            
            //Prints ball.colour success.
            System.out.println(ball.getColour());
        }
    }

    public class Ball {
        private String colour = "red";
        
        //getter
        public String getColour() {
            return colour;
        }
    }
}





********************
2. Inheritance
- Is the pattern of 'From one; Many.' It allows a super class that is abstract(or not) class to pass down it's properties and values to sub-classes. This would be used only for the most general methods and properties. Implemented by using the 'extends <Class To Be Inherited From>'.

Example: {

    public class Main{
        public static void main(String[] args) {
            Bird bird = new Bird();
            Snake snake = new Snake();
            
            //bird extends the Animal class
            // Bird is able to add additional methods to its own class
            bird.move();
            bird.fly();
            // Or the sub-class can override the super-classes' methods in the case of Snake
            snake.move();
        }
    }
    
    abstract class Animal {
        public void move(){
            System.out.println("Animal movement.");
        }
    }
    public class Bird extends Animal{
        public void fly(){
            System.out.println("Bird flies.");
        }
    }
    public class Snake extends Animal{
        @Override
        public void move(){
            System.out.println("Snake Slithers...");
        }
    }
}


********************
3. Abstraction
- Abstraction is a way to hide the internal implementation details for a class. It is use to make a 'prototype' for other classes. The main purpose of this is to hide the unnecessary details from other users. This condenses the application's complexity.

Example: {

    public class Main{
        public static void main(String[] args) {
            Bird bird = new Bird();
            bird.move();
            bird.fly();
        }
    }
    
    abstract class Animal {
        public abstract void breathe();    
        public void move(){
            breathe();
            System.out.println("Animal movement.");
        }
    }
    public class Bird extends Animal{
        @Override
        public void breathe() {
            //Breath of fresh air
        }    
        public void fly(){
            System.out.println("Bird flies.");
        }
    }
    

}





********************
4. Polymorphism
- Allows the programmer to have a base class that performs the most general routines of a type of classes. From this generalized class more specific classes can inherit from this and add functionality based on what is needed for the specific classes' need.
   
Example: See Snake class
{

    public class Main{
        public static void main(String[] args) {
            Snake snake = new Snake();

            snake.move();
        }
    }
    
    abstract class Animal {
        public void move(){
            System.out.println("Animal movement.");
        }
    }
    public class Snake extends Animal{
    //Snake morphs the move() into it's own purpose, addtional methods can be added to this class as well.
        @Override
        public void move(){
            System.out.println("Snake Slithers...");
        }
    }
}





Please write 1-3 paragraphs explaining these 4 concepts further.  Please provide a sufficient enough explanation about these pillars, as well as some examples to illustrate the practical use cases of these principles.  



