# Smells and Refactoring

## config

#### WebSecurityConfig

    1.Code smell: Clase WebSecurityConfig grande y difícil de mantener. 
    Técnica de refactorización: Separar las responsabilidades en clases más pequeñas y cohesivas, siguiendo el principio de responsabilidad única.

    2.Code smell: Violación del principio de abierto/cerrado en la clase WebSecurityConfig. 
    Técnica de refactorización: Aplicar el patrón de diseño Estrategia para permitir la extensión de la configuración de seguridad sin modificar la clase principal.

#### TokenProvider

    1. Code smell: Complejidad innecesaria. 
    Técnica de refactorización: Extraer métodos más pequeños y expresivos para mejorar la legibilidad y mantenibilidad.
    
    2.Code smell: Duplicación de código. 
    Técnica de refactorización: Identificar y extraer bloques de código duplicados a métodos separados.
    
    3.Code smell: Falta de encapsulamiento.
    Técnica de refactorización: Encapsular los campos y proporcionar métodos de acceso adecuados (getters y setters).
    
    4.Code smell: Nombres de métodos poco descriptivos.
    Técnica de refactorización: Renombrar los métodos con nombres más expresivos que reflejen su propósito.



## controller

#### User controller

    1.Code smell: Métodos demasiado largos en la clase. 
    Técnica de refactorización: Extraer métodos más pequeños con responsabilidades únicas.

    2.Code smell: Violación del principio de responsabilidad única en la clase. 
    Técnica de refactorización: Separar las responsabilidades en clases diferentes (por ejemplo, tener una clase dedicada a la autenticación y otra para el manejo de usuarios).

#### Clase SupplierController
    1.Code smell: Duplicación de código en las clases 
    Técnica de refactorización: Extraer una clase base o interfaz común para la funcionalidad compartida.

    2.Code smell: Falta de encapsulamiento en las clases 
    Técnica de refactorización: Utilizar métodos de acceso (getters y setters) en lugar de acceder directamente a los campos.

    3. Code smell: Clases anémicas (clases con poco o ningún comportamiento) 
    Técnica de refactorización: Mover el comportamiento relacionado a estas clases y enriquecerlas con métodos.

#### Clase WarehouseController
    1.Code smell: Duplicación de código en las clases
    Técnica de refactorización: Extraer una clase base o interfaz común para la funcionalidad compartida.

    2.Code smell: Falta de encapsulamiento en las clases
    Técnica de refactorización: Utilizar métodos de acceso (getters y setters) en lugar de acceder directamente a los campos.

     3. Code smell: Clases anémicas (clases con poco o ningún comportamiento) 
    Técnica de refactorización: Mover el comportamiento relacionado a estas clases y enriquecerlas con métodos.

## Model

#### Item

    1.Code smell: Clases con demasiados atributos.
    Técnica de refactorización: Aplicar el patrón de diseño Extract Class o crear clases más pequeñas y cohesivas para separar responsabilidades.

    2.Code smell: Métodos complejos en la clase Item (fillQuarantineLotInfo). 
    Técnica de refactorización: Extraer métodos más pequeños y expresivos para mejorar la legibilidad y mantenibilidad.

    3.Code smell: Métodos complejo (fillQuarantineLotInfo). 
    Técnica de refactorización: Extraer métodos más pequeños y expresivos para mejorar la legibilidad y mantenibilidad.

#### Order

    1.Code smell: Clases con demasiados atributos. 
    Técnica de refactorización: Aplicar el patrón de diseño Extract Class o crear clases más pequeñas y cohesivas para separar responsabilidades.

#### OrderLine

    1.Code smell: Clases con demasiados atributos. 
    Técnica de refactorización: Aplicar el patrón de diseño Extract Class o crear clases más pequeñas y cohesivas para separar responsabilidades.

#### Product

    1.Code smell: Clases con demasiados atributos. 
    Técnica de refactorización: Aplicar el patrón de diseño Extract Class o crear clases más pequeñas y cohesivas para separar responsabilidades.
    
    2.Code smell: Relaciones bidireccionales en algunas entidades. 
    Técnica de refactorización: Utilizar relaciones unidireccionales siempre que sea posible para evitar problemas de consistencia y rendimiento
    
    3.Code smell: Campos y atributos poco descriptivos (productField1, productField2). 
    Técnica de refactorización: Renombrar los campos y atributos con nombres más descriptivos que reflejen su propósito.
#### Supplier

    1.Code smell: Relaciones bidireccionales en algunas entidades. 
    Técnica de refactorización: Utilizar relaciones unidireccionales siempre que sea posible para evitar problemas de consistencia y rendimiento

    2.Code smell: Uso de colecciones sin tipo genérico (Set<SupplierContactPerson>). 
    Técnica de refactorización: Utilizar tipos genéricos para mejorar la seguridad y la legibilidad del código. 
#### Warehouse

    1.Code smell: Relaciones bidireccionales en algunas entidades. 
    Técnica de refactorización: Utilizar relaciones unidireccionales siempre que sea posible para evitar problemas de consistencia y rendimiento


    





