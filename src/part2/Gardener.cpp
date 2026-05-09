#include "Gardener.h"
#include <iostream>
#include <string>
#include <vector>
#include "FlowersBouquet.h"
#include "Person.h" 

Gardener::Gardener(std::string name)
	: Person(name) {

}
FlowersBouquet*  Gardener::prepareBouquet(std::vector<std::string> flowers) {
    std::cout << "Gardener " << getName() << " prepares the flowers." << std::endl;
    FlowersBouquet* bouquet = new FlowersBouquet(flowers);
    std::cout << "Gardener " << getName() << " returns the flowers to Grower." << std::endl;
    return bouquet;
}

