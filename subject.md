## Test Brief: Intermediate Minecraft Plugin Development with Spigot API

### Objective
Create an intermediate-level Minecraft plugin using the Spigot API that includes custom commands, event handling, GUI creation, and command cooldowns to deepen your understanding of the API and plugin development.

### Prerequisites
- Understanding of Java
- Familiarity with general development principles
- Basic knowledge of Minecraft and previous experience with the Spigot API

### Requirements

#### Plugin Structure
- **Project Setup:** Create a new project in your IDE with the necessary dependencies for Spigot.
- **Main Class:** Create a main class that extends `JavaPlugin`.
- **Plugin.yml:** Create a `plugin.yml` file in the `src/main/resources` directory with the following details:
  - `name`: Name of the plugin
  - `version`: Version of the plugin
  - `main`: Main class path
  - `author`: Your name
  - `description`: Short description of the plugin

#### Implement Features

##### a. Basic Command with Cooldown
- **Command Registration:** Register a command (`/hello`) in `plugin.yml`.
- **Command Cooldown:** Implement a cooldown period for the `/hello` command, preventing players from using it too frequently.
- **Command Implementation:** Implement the command in the main class to send a greeting message to the player.

##### b. Event Listener
- **Event Handling:** Create an event listener that listens for player join events and sends a welcome message to the player.
- **Registration:** Register the event listener in the main class.

##### c. Simple Custom Item
- **Item Creation:** Create a custom item (e.g., a renamed stick with enchantments) and give it to the player when they use the `/getitem` command.
- **Command Registration:** Register the `/getitem` command in `plugin.yml`.

##### d. GUI Menu
- **GUI Creation:** Implement a custom GUI (Graphical User Interface) that can be opened with the `/openmenu` command.
  - **GUI Design:** Create a simple inventory menu with a few items.
  - **Interaction Handling:** Handle item clicks within the GUI to perform specific actions (e.g., giving the player an item or sending a message).
- **Command Registration:** Register the `/openmenu` command in `plugin.yml`.

#### Documentation
- **ReadMe:** Write a ReadMe file with instructions on how to set up and use the plugin.
- **Code Comments:** Comment the code to explain the functionality of each section.

### Deliverables
- Complete Java project with source code
- Built plugin JAR file
- ReadMe file with setup and usage instructions

### Evaluation Criteria
- Correct setup and configuration of the Spigot plugin project
- Proper implementation and functionality of the specified features
- Effective command cooldown implementation
- Functional and user-friendly GUI
- Clean, well-documented, and maintainable code
