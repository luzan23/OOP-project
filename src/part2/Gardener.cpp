<<<<<<< HEAD
#include "Gardener.h"
#include <iostream>

Gardener::Gardener(std::string name) : Person(name){}

FlowersBouquet* Gardener::prepareBouquet(std::vector<std::string> flowers) {
  

}
=======
#include <string>
#include <vector>
#include "FlowersBouquet.h"
#include <Person.h>
#include <iostream> 

Gardener::Gardener(std::string name)
	: Person(name) {

}
FlowersBouquet*  Gardener::prepareBouquet(std::vector<std::string> flowers) {
    std::cout << "Gardener " << name << " prepares flowers." << std::endl;
    FlowersBouquet* bouquet = new FlowersBouquet(flowers);
    return bouquet;
}

>>>>>>> 8a202fc04fa9a0b3f6923c93cd991090ebe6226e
