class Solution {
public:
    vector<string> letterCombinations(string digits) {
       std::vector<std::string> result;
        if (digits.empty()) {
            return result;
        }

        std::map<char, std::string> mapping = {
            {'2', "abc"},
            {'3', "def"},
            {'4', "ghi"},
            {'5', "jkl"},
            {'6', "mno"},
            {'7', "pqrs"},
            {'8', "tuv"},
            {'9', "wxyz"}
        };

        std::string currentCombination = "";
        backtrack(digits, 0, currentCombination, mapping, result);

        return result;
    }

private:
    void backtrack(const std::string& digits, int index, std::string& currentCombination, 
                   const std::map<char, std::string>& mapping, std::vector<std::string>& result) {
        if (index == digits.length()) {
            result.push_back(currentCombination);
            return;
        }

        char digit = digits[index];
        std::string letters = mapping.at(digit);

        for (char letter : letters) {
            currentCombination.push_back(letter);
            backtrack(digits, index + 1, currentCombination, mapping, result);
            currentCombination.pop_back(); // Backtrack
        }  
    }
};