#include"Person.h"
#include <iostream>
#include <string>  
#include <vector>  

Person::Person(std::string name) : name(name)
 {
	
}
void  Person::orderFlowers(Florist* florist, Person* recipient, std::vector<std::string> flowers) {
	std::cout << name << "orders flowers to" << recipient->getName() << "from"<< florist-> getName() << std::endl;


}
void Person::acceptFlowers(FlowersBouquet* bouquet) {

}
std::string  Person::getName() {
	return name;
}

