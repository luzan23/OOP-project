#ifndef Person_H
#define Person_H
#include <string>  
#include <vector>  

class Person {
private:
    std::string name;
public:
    Person()
    void orderFlowers(Florist* florist, Person* recipient, std::vector<std::string> flowers);
    void acceptFlowers(FlowersBouquet bouquet);
};
#endif // !Person_H

