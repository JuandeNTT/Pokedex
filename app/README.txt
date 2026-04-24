**README PROYECTO**

Este proyecto es una Pokédex desarrollada en Android usando Kotlin, Jetpack Compose, Retrofit y arquitectura MVVM.

Se conecta a la API pública de PokéAPI para obtener una lista de Pokémon y sus detalles, gestionando la navegación entre pantallas (splash, listado y detalle) mediante Navigation Compose.
 La UI está basada en estados (`Loading`, `Success`, `Error`, `Empty`) para controlar la experiencia del usuario de forma reactiva.

En el setup se utiliza `Retrofit` con `GsonConverterFactory` para las peticiones HTTP y `Coil` para la carga de imágenes.
Se han tomado decisiones como limitar la lista a 50 Pokémon, paginar localmente con `chunked()` y mantener el estado del Pokémon seleccionado en el `ViewModel`.
Cuenta con un fichero Dimens para evitar hardcodear las unidades de medida. De igual forma con los textos.

Como limitaciones, el estado no es persistente (se pierde al recomponer o cerrar la app), no hay caché local y el manejo de errores es básico.

