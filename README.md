# MongoDB CRUD Application

## Overview
This Python application interacts with a MongoDB database to perform CRUD operations on three collections: `Courses`, `Users`, and `Tutors`. The code demonstrates how to:
* Connect to a MongoDB database
* Create, read, update, and delete documents
* Utilize various MongoDB query operators and methods

## Prerequisites
* Python installed
* pymongo library installed (`pip install pymongo`)
* A running MongoDB instance

## Configuration
* Replace the placeholder MongoDB connection string with your actual connection details.

## Usage

### Connecting to MongoDB
```python
client = pymongo.MongoClient("mongodb+srv://username:admin123@cluster0.xpbud77.mongodb.net/")
db = client["RecommendationSystem"]
