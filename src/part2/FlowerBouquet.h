#ifndef FLOWERSBOUQUET_H
#define FLOWERSBOUWUET_H

#include <vector>
#include <string>
class FlowersBouquet {
	private:
		std::vector<std::string> bouquet;
		bool is_arranged;
    public:
		FlowersBouquet(std::vector<std::string> Flowers);
		void arrange();
};
#endif // !FLOWERSBOUQUET_H
