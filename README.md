# Kata - Recursive Bruteforce
Small Kata project written in Java to recursively find / bruteforce a predefined string.

## Configuration and Parameters
You can simply create a `Bruteforce` instance for a predefined charset with one of the following factory methods:

- `getAlphaLowerChars()`: lower case charset
- `getAlphaUpperChars()`: upper case charset
- `getNumericChars()`: numeric charset
- `getSpecialChars()`: special character charset
- `getAlphaNumericUpperChars()`: alphanumeric upper charset
- `getAlphaNumericLowerChars()`: alphanumeric lower charset
- `getAlphaNumericChars()`: alphanumeric charset
- `getAllChars()`: all characters (upper case, lower case, numeric, special characters)

Alternatively you can use the following method if you want to use a custom charset:

- `getCustomChars(String chars)`: custom charset

Start the bruteforce with the `find(String word, int maxLength)` method:
- `word`: the word to bruteforce
- `maxLength`: the length limit for the bruteforce

For debug output or pre-generation of combinations take also a look on `setOutput(boolean)`, `setStore(boolean)` and `getPassStore()`.

## Disclaimer
DO NOT use this project or source code for illegal activities.

## Known Issues
None

## by [thex](https://github.com/thexmanxyz)
Copyright (c) 2018, free to use in personal and commercial software as per the [license](/LICENSE.md).
