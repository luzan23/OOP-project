#include"Person.h"
#include <iostream>
#include <string>  
#include <vector>  

Person::Person(std::string name) : name(name)
 {
	
}
void  Person::orderFlowers(Florist* florist, Person* recipient, std::vector<std::string> flowers) {
    std::cout << name << " orders flowers to " << recipient->getName()
        << " from Florist " << florist->getName() << ": ";
    for (int i = 0; i < flowers.size(); i++) {
        std::cout << flowers[i];
        if (i < flowers.size() - 1) {
            std::cout << ", "; 
        }
    }
    std::cout << "." << std::endl;
    florist->acceptOrder(recipient, flowers);
}
		
void Person::acceptFlowers(FlowersBouquet* bouquet) {
    std::cout << name << " accepts the flowers: ";
    std::vector<std::string> flowers = bouquet->getFlowers();
    for (int i = 0; i < flowers.size(); ++i) {
        std::cout << flowers[i];
        if (i < flowers.size() - 1) {
            std::cout << ", ";
        }
    }
    std::cout << "." << std::endl;
}
std::string  Person::getName() {
	return name;
}

