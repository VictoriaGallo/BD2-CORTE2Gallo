import pymongo

# Establece la conexión con el servidor MongoDB
client = pymongo.MongoClient("mongodb+srv://lauragallo:admin123@cluster0.xpbud77.mongodb.net/")

# Selecciona la base de datos
db = client["RecommendationSystem"]

# Selecciona las colecciones
coursesCollection = db["Courses"]
usersCollection = db["Users"]
tutorsCollection = db["Tutors"]

# ----------------- CREACIÓN DE DOCUMENTOS ------------------
# Crea un documento para insertar en la colección
newCourse = {
    "name": "Rust Programming",
    "category": "Programming Languages",
    "price": 0.0,
    "totalHours":40,
    "certification":True
}
#--- InsertOne: 
# Inserta un documento en la colección
insert_result = coursesCollection.insert_one(newCourse)
print("ID del documento insertado:", insert_result.inserted_id)

#--- InsertMany
# crea varios documentos en la colección
newUsers = [
     {"document":"666","name":"Diego Loaiza"},
     {"document":"777","name":"Diana Loaiza"},
     {"document":"888","name":"Sebastián Bonilla"}
 ]
insert_result = usersCollection.insert_many(newUsers)
print("ID de los documentos insertado:", insert_result.inserted_ids)


# ----------------- CONSULTA DE DOCUMENTOS ------------------
# Encuentra documentos que coincidan con un criterio de búsqueda
# --- find (devuelve varios documentos)
resultado_busqueda = coursesCollection.find({"totalHours": 
                                             {"$gt": 25}
                                             })  
# Encuentra cursos con número de horas mayor a 25
for documento in resultado_busqueda:
     print(documento)

#Consulta con operadores lógicos:
#consulta de cursos de música con número de horas mayor o igual a 25:
# ($gte, $eq, entre otros, son operadores relacionales o de comparación)
# ($and en este caso es un comparador lógico que opera sobre una lista de 
#  cláusulas relacionales)
resultado_busqueda = coursesCollection.find( { "$and": [
                                                        {"totalHours": {"$gte": 40}},
                                                        {"category":{"$eq":"Music"}}
                                                       ] 
                                             } )  
# Encuentra cursos con número de horas mayor a 25
for documento in resultado_busqueda:
     print(documento)

#--- findOne: devuelve solo un documento
resultado_busqueda = usersCollection.find_one({"document":
                                                    {"$eq":"777"}
                                               })

print(resultado_busqueda)



# Consulta de cursos con totalHours > N
def cursos_con_rantings_mayor_a_N(N):
    resultado_busqueda = coursesCollection.find({"totalHours": {"$gt": N}})
    for documento in resultado_busqueda:
        print(documento)

# Consulta de tutores con cursos con rating > N
def tutores_con_cursos_con_rating_mayor_a_N(N):
    resultado_busqueda = tutorsCollection.find({"courses.rating": {"$gt": N}})
    for documento in resultado_busqueda:
        print(documento)



# ----------------- ACTUALIZACIÓN DE DOCUMENTOS ------------------
# ---- updateOne y updateMany
#actualización de un documento:
#actualización o creación del campo edad de un usuario:
filtro = {"document": "777"}
#si la nueva llave no existe, la crea:
nuevos_valores = {"$set": {"age": 35}}  # Actualiza la edad a 35 años
actualizacion_resultado = usersCollection.update_one(filtro, nuevos_valores)
print("Número de documentos actualizados:", actualizacion_resultado.modified_count)

# ---- updateMany
#actualización de varios documentos:
filtro = {"totalHours": {"$gte": 40}}
nuevos_valores = {"$set": {"totalHours": 45}} 
actualizacion_resultado = coursesCollection.update_many(filtro, nuevos_valores)
print("Número de documentos actualizados:", actualizacion_resultado.modified_count)


# ----------------- ELIMINACIÓN DE DOCUMENTOS ------------------
# ---- deleteOne, deleteMany, findOneAndDelete
filtro_eliminacion = {"nombre": "Elon Musk"}
eliminacion_resultado = tutorsCollection.delete_one(filtro_eliminacion)
print("Número de documentos eliminados:", eliminacion_resultado.deleted_count)
