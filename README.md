# Додаток з бронювання білетів
Опис:
Консольна програма, яка в нескінченному циклі (до вибору команди Вихід) надає інтерфейс для пошуку та бронювання авіаквитків.


Павила в команді:
1. Перед мерджом в мейн нужно смерджить мейн со своей веткой.
2. убедится что всё работает а потом делать пул реквест в мейн.

#### Logger usage
```
Looger looger = new Logger();
looger.info()
or 
logger.info(paramtr)
parametr - string
```
Logs write to application.log


### Booking controller
Методы контроллера которые изменяют контроллер(добавить пассажиров, удалить, добавить брони и тд.) также меняют бд и перезаписывают файлы бд.
#### Creating controller
`BookingController bc = new BookingController();` -пустой контроллер

`BookingController bc = new BookingController(new BookingService())` -пустой контроллер;
BookingController bc = new BookingController();
#### Описание методов контроллера 

| Возвращает   |                        Метод                        | Описание                                                                  |
|:--------------|:---------------------------------------------------:|:--------------------------------------------------------------------------|
| void         |        setController()  | назначить контроллер        |
| Optional<Booking<Flight>>   |                 findById(String id)                 | поиск по УИД Брони                                                        |
| ArrayList<Booking<Flight>>|                      getall()                       | Получить все Брони                                                        |
| boolean|        dropByClass(Booking<Flight>  booking)        | Удалить по обєкту брони                                                   |
| boolean|                dropByUID(String UID)                | Удалить по UID                                                            |
| void |                       count()                       | Возвращает обшее количество брони                                         |
| boolean |           save(Booking<Flight>  booking)            | Добавляет брноь + сохраняет в файл                                        |
| ArrayList<Booking<Flight> > |                     loadData()                      | Загрузка с файлов контроллера                                             |
| ArrayList<Booking<Flight> > |             search(String nameorLname)              | Поиск по имени или фамилии в списке пассажиров                            |
| ArrayList<Booking<Flight> > |         search(String name,String lastname)         | Поиск по имени и по фамилии                                               |
| boolean | addPassanger(String UID,String name, String lName)  | Добавить пассажира необходимо передать УИД брони, имя и фамилию пассажира |
| boolean | dropPassenger(String UID,String name, String lName) | Удалить пассажира необходимо передать УИД брони, имя и фамилию пассажира  |

### ControllerFlight
#### Описание методов контроллера 

| Возвращает   |                        Метод                        | Описание                                                                  |
|:--------------|:---------------------------------------------------:|:--------------------------------------------------------------------------|
| void         |        generateFlights(int amount) | генерирует amount новых рейсов в базу данных        |
| ArrayList<Flight>   |     getSpecific(Airport dest, LocalDate date, int places))                 | выдаёт список рейсов с нужной датой, местом назначения и количеством мест большей или равной places                                                 |
| ArrayList<Flight> |                      getall()                       | выдаёт все рейсы                                                     |
| Flight | getByID(int id) | выдаёт один рейс по его ID |
| void | add(Flight flight)| добавляет новый рейс в базу данных |
| ArrayList<Flight> | nextFlights() | выдаёт список рейсов в следующие 24 часа|
| void | takeSeats(int flightId, int count) | находит по ID рейс и отнимает у него count свободных мест |
| void | freeSeats(int flightId, int count) | находит по ID рейс и добавляет ему count свободных мест |
| void | saveToFile() | сохраняет всю базу данных рейсов в файл |
| void | loadFromFile() | очищает существующую в программе базу данных рейсов и загружает рейсы из файла |