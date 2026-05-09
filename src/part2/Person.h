#pragma once 

#include <string>  
#include <vector>  
#include "FlowersBouquet.h"
class Florist;
class Person {
private:
    std::string name;
public:
    Person(std::string name);
    void orderFlowers(Florist* florist, Person* recipient, std::vector<std::string> flowers);
    void acceptFlowers(FlowersBouquet* bouquet);
    std::string getName();
};

