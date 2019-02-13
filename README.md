Branch Master

Command line instructions

Git global setup
```
git config --global user.name "Leonard Espíritu"
git config --global user.email "leonard.espiritu@gmail.com"
```

Create a new repository
```
git clone https://gitlab.com/leonard.espiritu/workshop-022019.git
cd workshop-022019
touch README.md
git add README.md
git commit -m "add README"
git push -u origin master
```

Existing folder
```
cd existing_folder
git init
git remote add origin https://gitlab.com/leonard.espiritu/workshop-022019.git
git add .
git commit -m "Initial commit"
git push -u origin master
```

Existing Git repository
```
cd existing_repo
git remote rename origin old-origin
git remote add origin https://gitlab.com/leonard.espiritu/workshop-022019.git
git push -u origin --all
git push -u origin --tags
```