# Google Calendar Automation:

Google Calendar is a widely used web-based calendar application developed by Google. It provides a comprehensive and user-friendly platform for organizing, scheduling, and managing events, tasks, and appointments.
Key features of Google Calendar include seamless integration with other Google services, such as Gmail, which allows users to easily add events from their emails. The application offers various view options, including day, week, month, and year views, allowing users to customize their calendar experience. Additionally, Google Calendar provides event reminders, collaborative features for shared calendars, and the ability to set goals and track progress. The calendar is accessible across multiple devices, ensuring users can stay organized and up-to-date whether using a computer or a mobile device.

---

**TestCase01:** *Verify Calendar Home Page*

- **Description:** Verify the URL of the Google Calendar home page

**Test Steps:**

- Navigate to Google Calendar ( https://calendar.google.com/ ).

- Verify that the current URL contains "calendar."

**Expected Result:** The URL of the Calendar homepage contains "calendar".

---

**TestCase02:** *Verify Calendar Navigation and Add Task*

- **Description:** Switch to the month view, and add a task for today.

**Test Steps:**

- Switch to the month view.

- Click on the calendar to add a task.

- Navigate to the Tasks tab.

* Select a date and enter task details. Task Details:

  - *Title:* Crio INTV Task Automation

  - *Description:* Crio INTV Calendar Task Automation

**Expected Result:** The Calendar switched to month view and a task was created.

---

**TestCase03:** *Verify the Task Updation*

- **Description:** Select an existing task, update its description, and verify the successful update.

**Test Steps:**

- Click on an existing task.

- Open the task details.

- Update the task description to "Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application"

- Verify that the updated description is displayed.

**Expected Result:** The task description is successfully updated and displayed.

---

**TestCase04:** *Verify the Task deletion*
- **Description:** Delete an existing task and confirm the deletion.

**Test Steps:**

- Click on an existing task.

- Open the task details.

- Verify the title of the task.

- Delete the task.

- Confirm the task deletion, by verifying "Task deleted" is displayed.

**Expected Result:** The task is successfully deleted, and the confirmation message indicates "Task deleted"

---
