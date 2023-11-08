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

