# NP-EC-Robocode
A repository for Robocode bots made by New Paltz students for Eleet Coders Robocode events.

## Creating your Bot

### Robocode Resources
You can utilize the following resources to create your bot.
- [Robocode Tank Royale Docs](https://robocode.dev/)
- [Robocode API Docs](https://robocode.dev/api/apis.html)
- [Robocode Tank Royale GitHub](https://github.com/robocode-dev/tank-royale)

Consider downloading the Robocode Tank Royale GUI as well as the sample bots to test out your bot during development.

### Set-Up
First, fork this repository to your personal account. This will create an identical, independent copy of this repository. Then, you can clone the forked repository to your local machine and begin working on your bot.

### File Organization
Your bot's directory should consist of the following:
- Bot directory
    - Windows command script (.cmd) containing the command to run your bot in Windows
    - Java source file (.java) containing the code of your bot's behavior
    - JSON source file (.json) containing info about your bot
    - SH source file (.sh) containing the command to run your bot in Linux/Macos

For example, ExampleBot's directory is as follows:
- ExampleBot
    - ExampleBot.cmd   
    - ExampleBot.java
    - ExampleBot.json
    - ExampleBot.sh

### .cmd and .sh Files
You need to specify where the Robocode API is located in your bot's .cmd and .sh files.
Copy the snippet below and modify it as directed:
```
java -cp .../lib/* [your-bot-here].java >nul
```
```
#!/bin/sh
java -cp .../lib/* [your-bot-here].java
```
Just change [your-bot-here] to the name of your bot.
Note that the lib directory will be two levels away from your .cmd or .sh file in this case.

### Pushing your Fork
When you are done making your bot, make a pull request to merge your fork back with the original repository.