import subprocess
import os

# === CONFIGURATION ===
REPO_PATH = r"E:\VIT\LitCoder\LitCoder"  # path to your local GitHub repo
BRANCH = "main"

# === SCRIPT ===
def add_to_github(filename, code, commit_message):
    os.chdir(REPO_PATH)

    # Write the code to the file
    with open(filename, "w", encoding="utf-8") as f:
        f.write(code)

    # Git add, commit, and push
    # subprocess.run(["git", "add", filename], check=True)
    # subprocess.run(["git", "commit", "-m", commit_message], check=True)
    # subprocess.run(["git", "push", "origin", BRANCH], check=True)

    # print(f"✅ {filename} pushed to {BRANCH} branch successfully!")

# === Example usage ===
if __name__ == "__main__":
    while 1:
        filename = input("Enter the filename (e.g. script.py): ")
        # commit_message = input("Enter the commit message: ")
        commit_message = "minor changes"
        # print("Enter your code (end with an empty line):")

        # Take multiline input for the code
        # code_lines = []
        # while True:
        #     line = input()
        #     if not line:
        #         break
        #     code_lines.append(line)
        # code = "\n".join(code_lines)
        code = " "

        add_to_github(filename + ".java", code, commit_message)
