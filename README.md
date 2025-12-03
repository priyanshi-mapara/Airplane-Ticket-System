# AeroFly Ticketing (Airplane Ticket System)

AeroFly Ticketing is a desktop Java Swing application for booking airline tickets. It follows an MVC structure to keep the UI, business logic, and data models organized, offering passengers a streamlined way to select routes, ticket classes, and see fare breakdowns in real time.

<img width="1440" height="900" alt="Screen Shot 2025-12-02 at 9 38 04 PM" src="https://github.com/user-attachments/assets/9e4a9845-5d6c-4082-8618-59d78a53e5a6" />


## Features
- **Class and ticket selection:** Choose Economy, Business, or First class and toggle between single or return tickets.
- **Dynamic fare calculation:** Fare breakdowns update as you adjust passengers or destinations, including tax and totals.
- **Ticket summary card:** Displays generated ticket numbers, route information, and timestamps.
- **Input validation:** Prompts for missing choices and prevents invalid passenger counts.
- **Clear actions:** Calculate, reset, or exit via dedicated controls.

## Project structure
- `Travel_Project/src/Travel_Tickets` – application sources.
  - `TravelApp.java` – entry point that wires up the MVC components.
  - `controller/TravelController.java` – connects the view to the fare calculator and keeps totals in sync.
  - `service/` – fare calculation and ticket number utilities.
  - `model/` – domain objects such as `Ticket`, `Destination`, and fare breakdowns.
  - `view/TravelView.java` – Swing UI for configuring and summarizing bookings.
- `docs/images/booking-screen.svg` – illustrative screenshot of the UI layout.

## Getting started
1. **Build**
   ```bash
   javac -d out $(find Travel_Project/src -name "*.java")
   ```
2. **Run**
   ```bash
   java -cp out Travel_Tickets.TravelApp
   ```
3. **Interact**
   - Select a class and ticket type.
   - Pick a destination and set adult/child counts.
   - Click **Calculate** to generate totals and a ticket summary.

## Notes
- The included SVG screenshot mirrors the layout and styling defined in `TravelView`; generate a live view by running the app locally.
- If your environment lacks a display server, launch the app inside a virtual framebuffer (e.g., `xvfb-run`) to render the Swing UI.
