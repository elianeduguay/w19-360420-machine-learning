# Machine Learning - Report 
## Eliane Duguay

## Amount of Confidence


## Description of Scientific Model and Computational Methods  
The scientific model that will be used is the microscopic traffic model, more specifically the cellular automaton model. This model is described in the article, “Modeling and Simulation of Highway Traffic Using a Cellular Automaton Approach” (Ding). The model can be described as follows. There is an i number of cars that each have an initial cell x_i and their position is updated dependant on their speed v_i. v_i being the given number of cells travelled per second. There is an assumption that a car i can never be in the same cell as car i+1. Since this is the case, if car i is in an adjacent cell to car i+1, then, its speed will go to 0.  In addition, a car must reduce its speed to 〖gap〗_i −1 if 𝑣𝑚𝑎𝑥 is bigger than this number. 
Since the circle will be divided into 160 cells and that there are 16 cars equally spaced from each other, the maximum number of empty cells there can be is 9. Using this information, it can be deducted that:

![(1)](./images/equation1.PNG)  

Therefore, by taking the derivative, the maximum speed can be found by:
 
![(2)](./images/equation2.PNG)  

By using Euler’s method, an ODE solving approach, the new position is:

![(3)](./images/equation3.PNG) 
 
Where, (gap)_i is the numbers of cell between two adjacent cars. For our purposes, dt will be taken to be equal to 0.01s. 
In the same orders of ideas, the deceleration of a vehicle can be calculated by,

![(4)](./images/equation4.PNG)  

Where, 

![(5)](./images/equation5.PNG)    

The disturbance will happen at time t = 10s, where car 10 will decelerate until it speed reaches 1 cell per second. The speed of this car at t = 10s will be equal to 9⁄dtuntil it reaches a speed of 1 cell per second at which point the speed stabilizes. Again, using Euler’ method, the speed of that car will be calculated by,

![(6)](./images/equation6.PNG)  

Giving,

![(7)](./images/equation7.PNG)
  
It is important to note that only the speed and acceleration of car 10 is given by equations (6) and (7). All the other car’s speed and positions will be calculated by the initial equations given. 
The following equations are to calculate the mean speed and the density respectively:

![(8)](./images/equation8.PNG)                                                                  

Where v_(t )is the mean speed and m represents the numbers of car present at a specific time and v_i is the speed of car i at the same specific time. 

![(9)](./images/equation9.PNG)  

Where k is the density and s is the spacing between the first and the last car (the spacing must contain all the cars in between).

## Test cases

For the graphs we want to generate, we except them to like look those in the article "Car Following Models" (Rothery) and "Traffic Flow Theory". We clearly see that the function of the graphs is inversely proportional.
![(10)](./images/graph1.png) Figure 1      ![(11)](./images/graph2.png)     Figure 2
 
Figure 1 and figure 2 are graphs of cars’ speed vs density. Although we want to see the linear dependence between the mean speed and the density, we still expect to generate a graph that is similar to Figure 1 and Figure 2. 

## Bibliography.
Ding, Ding. "Modeling and Simulation of Highway Traffic Using a Cellular Automaton Approach", Uppsala University, December 2011, https://www.diva-portal.org/smash/get/diva2:483914/FULLTEXT01.pdf. Accessed 26 April 2019.

 Rothery, Richard W. "Car following models", The University of Texas, 
https://ocw.mit.edu/courses/civil-and-environmental-engineering/1-225j-transportation-flow-systems-fall-2002/lecture-notes/carfollowinga.pdf. Accessed 24 April 2016.

Hall, Fred L. "Traffic Flow Theory",McMaster University, 1992, http://citeseerx.ist.psu.edu/viewdoc/download;jsessionid=0E2A546C8C7ED851FE7131BF57CE83EB?doi=10.1.1.96.5258&rep=rep1&type=pdf. Accessed 24 April 2019.   

