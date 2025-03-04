
## **GitHub Activity CLI 🚀**

![GitHub](https://img.shields.io/badge/GitHub-Activity%20CLI-blue?logo=github&style=flat-square)

A simple command-line interface to fetch and display recent activity of any GitHub user.

---

## **Features ✨**
- Fetches **recent activity** of a specified GitHub user.
- Simple **command-line usage**.

---

## **Prerequisites 📋**
- **Java 21** _*If you have other versions of Java installed, you can change the version in the `pom.xml` file._
- **Maven** _*To build the project._

## **How It Works 🛠️**

1. The CLI takes a **GitHub username** as an argument.
2. It makes a request to the **GitHub Events API**:
   ```
   https://api.github.com/users/<username>/events
   ```
---

## **Installation 🧑‍💻**

### 1. Clone the repository
```bash
git clone https://github.com/Kunashigui/GitHubUserActivity.git
cd github-activity-cli
```

### 2. Run the application
```bash
mvn compile exec:java -Dexec.arguments=Kunashigui
```
#### For Windows
```bash
mvn compile exec:java -D"exec.arguments"=Kunashigui
```
---

**Sample Output:**
```
Push Event to Repository: Kunashigui/public_test
Created Repository: Kunashigui/public_test
Created Repository: Kunashigui/public_test
Created Issue in Repository: bdkamaci/github-activity
Created Issue in Repository: KenyTuan/github-activity
```

---

## **Technologies Used 🛠️**
- **Java**
- **Maven**

---

- Uploaded to [roadmap.sh](https://roadmap.sh/projects/github-user-activity).


## **Contributors ✨**
- I took the base README from [iOmega17](https://github.com/iOmega17/GitHub-activity-CLI)
