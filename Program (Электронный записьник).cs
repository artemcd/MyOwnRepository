using System;
using System.Collections.Generic;

namespace ConsoleAppList
{
    class Program
    {
        private int id = 0;
        public static int Id {get; set;}

        static void Main(string[] args)
        {
            Console.WriteLine("Добро пожаловать в Вашу личную телефонную книжку!\n" +
                "Меню:\n" +
                "1) Для добавления нового абонента введите \"1\";\n" +
                "2) Для редактирования записи уже добавленного абонента введите \"2\";\n" +
                "3) Для удаления абонента введите \"3\";\n" +
                "4) Для просмотра всех записей в книги введите \"4\";\n" +
                "5) Для просмотра краткой информации об абонентах введите \"5\".");

            for (; ; )
            {
                string comandFromMenu = Console.ReadLine();

                if (comandFromMenu == "1")
                {
                    AddUser();

                }
                else if (comandFromMenu == "2")
                {
                    Redactor();
                }
                else if (comandFromMenu == "3")
                {
                    Remove();
                }
                else if (comandFromMenu == "4")
                {
                    GetFullList();
                }
                else if (comandFromMenu == "5")
                {
                    GetShortList();
                }
                else
                {
                    Console.WriteLine("Ты не туда воюешь! Выбери что-нибудь из скромного списочка ниже. \n\n");
                    GetMenu();
                }
            }
        }


        public static void GetMenu()
        {
            Console.WriteLine("Введите команду из  Меню:\n" +
                "1) Для добавления нового абонента введите \"1\";\n" +
                "2) Для редактирования записи уже добавленного абонента введите \"2\";\n" +
                "3) Для удаления абонента введите \"3\";\n" +
                "4) Для просмотра всех записей в книги введите \"4\";\n" +
                "5) Для просмотра краткой информации об абонентах введите \"5\".");
        }

        /*=======================ДОБАВЛЯЕМ НОВОГО ПОЛЬЗОВАТЕЛЯ================*/
        public static void AddUser()
        {
            Console.WriteLine("Введите через проблем следующую информацию об абоненте:\n" +
                "Фамилия Имя Страна Номер телефона");
            bool isItRealInfo = false;
            while (isItRealInfo == false)
            {
                string mainInfoString = Console.ReadLine();
                string[] mainInfoArr = mainInfoString.Split(' ');
                if (mainInfoArr.Length != 4)
                {
                    Console.WriteLine("Некорректное количество введённых элементов. Должно быть 4");
                }
                else
                {
                    try { 

                    PageOfNote pg = new PageOfNote(mainInfoArr[1], mainInfoArr[0], Int64.Parse(mainInfoArr[3]), mainInfoArr[2]);
                    PageOfNote.listOfAddr.Add(Id, pg);
                    Program.Id++;

                    Console.WriteLine("Для добавления ещё одного абонента нажмите 1 \n " +
                        "Для добавления новой информации о текущем абоненте нажмите 2\n Для перехода в основное меню нажмите 3 ");
                    string comand123 = Console.ReadLine();

                    if (comand123 == "3")
                    {
                        isItRealInfo = true;
                        GetMenu();
                    }
                    else if (comand123 == "2")
                    {
                        bool isthisTheAllLast = false;
                        while (isthisTheAllLast == false)
                        {

                            Console.WriteLine("Для редактирования: \n" +
                                "1) Имени нажмите 1;\n" +
                                "2) Фамилии нажмите 2;\n" +
                                "3) Отчества нажмите 3;\n" +
                                "4) Страны нажмите 4;\n" +
                                "5) Номера телефона нажмите 5;\n" +
                                "6) Места работы нажмите 6;\n" +
                                "7) Должности нажмите 7;\n" +
                                "8) Даты рождения нажмите 8;\n" +
                                "9) Комментариев нажмите 9;\n" +
                                "10) Для выхода в основное меню нажмите 10.\n");
                            string numberOfComanf = Console.ReadLine();

                            switch (numberOfComanf)
                            {
                                case "1":
                                    Console.WriteLine("Введите новое имя абонента: ");

                                    PageOfNote.listOfAddr[Id - 1].FirstName = Console.ReadLine();
                                    break;
                                case "2":
                                    Console.WriteLine("Введите фамилию абонента: ");

                                    PageOfNote.listOfAddr[Id - 1].LastName = Console.ReadLine();
                                    break;
                                case "3":
                                    Console.WriteLine("Введите отчество абонента: ");

                                    PageOfNote.listOfAddr[Id - 1].FatherName = Console.ReadLine();
                                    break;
                                case "4":
                                    Console.WriteLine("Введите страну абонента: ");

                                    PageOfNote.listOfAddr[Id - 1].Country = Console.ReadLine();
                                    break;
                                case "5":
                                    Console.WriteLine("Введите телефон абонента: ");

                                    PageOfNote.listOfAddr[Id - 1].PhoneNumber = Int32.Parse(Console.ReadLine());
                                    break;
                                case "6":
                                    Console.WriteLine("Введите место работы абонента: ");

                                    PageOfNote.listOfAddr[Id - 1].WorkPlace = Console.ReadLine();
                                    break;
                                case "7":
                                    Console.WriteLine("Введите должность абонента: ");

                                    PageOfNote.listOfAddr[Id - 1].Job = Console.ReadLine();
                                    break;
                                case "8":
                                    Console.WriteLine("Введите дату рождения абонента: ");

                                    PageOfNote.listOfAddr[Id - 1].Birthday = DateTime.Parse(Console.ReadLine());
                                    break;
                                case "9":
                                    Console.WriteLine("Введите заметку про абонента: ");

                                    PageOfNote.listOfAddr[Id - 1].Comment = Console.ReadLine();
                                    break;
                                case "10":
                                        isItRealInfo = true;
                                    isthisTheAllLast = true;

                                    GetMenu();
                                    break;
                            }
                        }
                    }
                    else if (comand123 == "1")
                    {
                        Console.WriteLine("Введите через проблем следующую информацию об абоненте:\n" +
                                       "Фамилия Имя Страна Номер телефона");
                    }
                    else
                    {
                        Console.WriteLine("Ошибка! Такой команды у нас нет =( ");
                    }
                }catch (Exception e)
                {
                    Console.WriteLine("Ошибка! Кажется кто-то пытлася добавить в телефон не только цифры =( ");

                }



            }
            }
        }
        /*/////////////////////////ДОБАВЛЯЕМ НОВОГО ПОЛЬЗОВАТЕЛЯ\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\*/





        public static void GetShortList()
        {
            Console.WriteLine("===========================================");
            foreach(KeyValuePair<int, PageOfNote> pg in PageOfNote.listOfAddr)
            {
                Console.WriteLine("ID: " + pg.Key + "   " + pg.Value.LastName + " " + pg.Value.FirstName + " " + pg.Value.PhoneNumber);
                
            }
            Console.WriteLine("===========================================");
            Console.WriteLine("\n\n\n Список был выведен. Вы автоматически перенаправлены в основное меню.\n\n");
            GetMenu();
        }



        public static void GetFullList()
        {
            Console.WriteLine("===========================================");
            foreach (KeyValuePair<int, PageOfNote> pg in PageOfNote.listOfAddr)
            {
                Console.WriteLine("ID: " + pg.Key + "   " + pg.Value.LastName + " " + pg.Value.FirstName + " " +  pg.Value.FatherName + " " + pg.Value.PhoneNumber + " " + "Страна: " + pg.Value.Country + " " + "Дата рождения: " +pg.Value.Birthday + " " +
                    "Место работы: " + pg.Value.WorkPlace + " " + " Должность: " + pg.Value.Job + " " + "Комментарий: " + pg.Value.Comment );

            }
            Console.WriteLine("===========================================");
            Console.WriteLine("\n\n\n Список был выведен. Вы автоматически перенаправлены в основное меню.\n\n");
            GetMenu();
        }

        public static void Redactor()
        {
            bool istheLastAct = false;

            while (istheLastAct == false)
            {
                Console.WriteLine("Введите Id абонента для редактирования или команду Меню для выхода в основное меню: ");
                string firstComand = Console.ReadLine();
                if (firstComand == "Меню")
                {
                    istheLastAct = true;
                    GetMenu();
                } else {

                    try
                    {
                        int idOfPerson;
                        idOfPerson = Int32.Parse(firstComand);
                        if (PageOfNote.listOfAddr.ContainsKey(idOfPerson))
                        {
                            Console.WriteLine("Получен абонент для редактирования: \n" +
                                PageOfNote.listOfAddr[idOfPerson].LastName + " " + PageOfNote.listOfAddr[idOfPerson].FirstName + "\n");
                            bool isthisTheAllLast = false;
                            while (isthisTheAllLast == false)
                            {

                                Console.WriteLine("Для редактирования: \n" +
                                    "1) Имени нажмите 1;\n" +
                                    "2) Фамилии нажмите 2;\n" +
                                    "3) Отчества нажмите 3;\n" +
                                    "4) Страны нажмите 4;\n" +
                                    "5) Номера телефона нажмите 5;\n" +
                                    "6) Места работы нажмите 6;\n" +
                                    "7) Должности нажмите 7;\n" +
                                    "8) Даты рождения нажмите 8;\n" +
                                    "9) Комментариев нажмите 9;\n" +
                                    "10) Другого абонента нажмите 10;\n" +
                                    "11) Для выхода в основное меню нажмите 11.\n");
                                string numberOfComanf = Console.ReadLine();

                                switch (numberOfComanf)
                                {
                                    case "1":
                                        Console.WriteLine("Введите новое имя абонента: ");

                                        PageOfNote.listOfAddr[idOfPerson].FirstName = Console.ReadLine();
                                        break;
                                    case "2":
                                        Console.WriteLine("Введите фамилию абонента: ");

                                        PageOfNote.listOfAddr[idOfPerson].LastName = Console.ReadLine();
                                        break;
                                    case "3":
                                        Console.WriteLine("Введите отчество абонента: ");

                                        PageOfNote.listOfAddr[idOfPerson].FatherName = Console.ReadLine();
                                        break;
                                    case "4":
                                        Console.WriteLine("Введите страну абонента: ");

                                        PageOfNote.listOfAddr[idOfPerson].Country = Console.ReadLine();
                                        break;
                                    case "5":
                                        Console.WriteLine("Введите телефон абонента: ");

                                        PageOfNote.listOfAddr[idOfPerson].PhoneNumber = Int64.Parse(Console.ReadLine());
                                        break;
                                    case "6":
                                        Console.WriteLine("Введите место работы абонента: ");

                                        PageOfNote.listOfAddr[idOfPerson].WorkPlace = Console.ReadLine();
                                        break;
                                    case "7":
                                        Console.WriteLine("Введите должность абонента: ");

                                        PageOfNote.listOfAddr[idOfPerson].Job = Console.ReadLine();
                                        break;
                                    case "8":
                                        Console.WriteLine("Введите дату рождения абонента: ");

                                        PageOfNote.listOfAddr[idOfPerson].Birthday = DateTime.Parse(Console.ReadLine());
                                        break;
                                    case "9":
                                        Console.WriteLine("Введите заметку про абонента: ");

                                        PageOfNote.listOfAddr[idOfPerson].Comment = Console.ReadLine();
                                        break;
                                    case "10":
                                        isthisTheAllLast = true ;
                                        break;
                                    case "11":
                                        isthisTheAllLast = true;

                                        istheLastAct = true;
                                        GetMenu();
                                        break;
                                }
                            }
                        }
                        else
                        {
                            Console.WriteLine("Абонента с таким Id не существует.\n");
                        }
                    } catch (Exception e)
                    {
                        Console.WriteLine("Абонента с таким Id не существует.\n");

                    }
                
                   
                }
            }
        }


        public static void Remove ()
        {
            Console.WriteLine("Введите Id абонента, от которого хотите избавиться: ");
            try
            {
                int idOfPerson = Int32.Parse(Console.ReadLine());
                if(PageOfNote.listOfAddr.ContainsKey(idOfPerson))
                {
                    Console.WriteLine("Абонент " + PageOfNote.listOfAddr[idOfPerson].LastName + " " + PageOfNote.listOfAddr[idOfPerson].FirstName + " был удалён");

                    PageOfNote.listOfAddr.Remove(idOfPerson);
                } else
                {
                    Console.WriteLine("В вашей записной книжке нет абонента с таким Id =(");
                }
            }catch(Exception e)
            {
                Console.WriteLine("В вашей записной книжке нет абонента с таким Id =(");

            }
            GetMenu();

        }









    }


    public class PageOfNote
    {
        private string firstName;
        private string lastName;
        private string fatherName;
        private long phoneNumber;
        private string country;
        private DateTime birthday;
        private string workPlace;
        private string job;
        private string comment;
        public static Dictionary<int, PageOfNote> listOfAddr = new Dictionary<int, PageOfNote>();

        public string FirstName { get => firstName; set => firstName = value; }
        public string LastName { get => lastName; set => lastName = value; }
        public string FatherName { get => fatherName; set => fatherName = value; }
        public long PhoneNumber { get => phoneNumber; set => phoneNumber = value; }
        public string Country { get => country; set => country = value; }
        public DateTime Birthday { get => birthday; set => birthday = value; }
        public string WorkPlace { get => workPlace; set => workPlace = value; }
        public string Job { get => job; set => job = value; }
        public string Comment { get => comment; set => comment = value; }

        public PageOfNote(string firstName, string lastName, long phoneNumber, string country)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.country = country;

        }
    }
}

