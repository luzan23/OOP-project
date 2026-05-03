#ifndef GARDENER_H
#define GARDENER_H

#include <string>
#include <vector>
#include "FlowersBouquet.h"
<<<<<<< HEAD
#include "Person.h"

class Gardener : public Person{
=======
#include<Person.h>

class Gardener : public Person {

>>>>>>> 8a202fc04fa9a0b3f6923c93cd991090ebe6226e
public:
    Gardener(std::string name);

    FlowersBouquet* prepareBouquet(std::vector<std::string> flowers);

};

#endif