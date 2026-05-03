#ifndef Person_H
#define Person_H
#include <string>  
#include <vector>  

class Person {
private:
    std::string name;
public:
    Person(std::string name)
    void orderFlowers(Florist* florist, Person* recipient, std::vector<std::string> flowers);
    void acceptFlowers(FlowersBouquet bouquet);
    std::string getName();
};
#endif // !Person_H

