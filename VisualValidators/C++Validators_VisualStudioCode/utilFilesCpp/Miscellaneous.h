#ifndef MISCELLANEOUS
#define MISCELLANEOUS
#include <filesystem>
#include <vector>

using namespace std;
namespace fs = std::filesystem;

class Miscellaneous {
public:
    Miscellaneous();
    ~Miscellaneous();

    string readFile(int linea, const fs::path& directorio);

    vector<string> readFile(const fs::path& directorio);

    void writeFile(const string& cadena, const fs::path& directorio, bool append);

    string convertDate(const string& date);
};

#endif
