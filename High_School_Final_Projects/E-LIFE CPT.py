high=0
low=0
x= 0
import time

while True:
    spouse = ''
    school = ''
    age = 100
    spouse = ''

#Menu
    print ('        E-Life       ')
    menu = input('Press Enter to go to Menu: ')
    if menu == '':
        print ('')
        print ('Menu')
        print ('1- Play')
        print ('2- Instructions')
        print ('3- Credits')
        print ('4- Exit')
        user = int(input('Enter choice: '))

#Choices
#Exit
    if user == 4:
        break

#Credits
    if user == 3:
        print ('You have played',x,'time(s)')
        print ('The longest you have ever lived is ',high,' years!')
        print ('The shortest you have lived is ',low,' years!')
        exit = input('Press enter to exit')
        for m in range(1,51):
            print ('')

#Instructions
    if user == 2:
        print ('Welcome to e-life!')
        print ('You will run through an automated life and make decisions for yourself.')
        print ('Your decisions will impact the span and quality of your life so choose wisely.')
        exit = input('Press enter to exit')
        for m in range(1,51):
            print ('')

#Game
    if user == 1:
        x = x + 1

        #promting
        i = 0
        firstName = input('Enter first name: ')
        lastName = input('Enter last name: ')
        location= input('Enter a location (Country/City): ')
        print ('')


        #high and low
        while True:

            if i >= age:
                if x == 1:
                    low = i
                if i > high:
                    high = i
                if i < low:
                    low = i
                print('You passed away due to natural causes 😇☠️')
                print ('')
                end = input('Press Enter to Return to Home Page: ')
                if end == '':
                    for m in range (0,51):
                        print ('')
                    break

            #Printing
            print ('Age:'+str(i)+' years')
            if i == 0:
                print ('Your name is',firstName,lastName)
                print ('You were just born in', location)

            #Time and Spacing
            time.sleep(1)
            print ('')

            #Desicion
            if i == 3:
                answer = int(input('You just broke a picture frame. Do you tell your parents?(1- yes 2- no): '))
                if answer == 1:
                    print ('Your parents were proud that you were honest and bought you ice cream!')
                    age = age + 3
                else:
                    print ('Your parents found out you broke it and yelled at you.')
                    age = age - 1
                print ('')

            #Desicion
            if i == 4:
                print ('You started school')
                print('')

            #Desicion
            if i == 7:
                y= int(input('Your parents ask you if you want to go on vacation.  What do you say?(1- yes 2- no): '))
                if y == 1:
                    print ('You went to Costa Rica for vacation')
                    print ('You had a great time with your family and made a new friend on vacation!')
                    age = age + 2
                else:
                    age = age - 3
                    print ('You stayed home and ended up getting lice at school')
                print ('')

            #Desicion
            if i == 12:
                r= int(input('You are going to the carnival today. Would you rather take your best friend or your crush?(1- crush 2- best friend): '))
                if r == 1:
                    print ('You get to the carnival and your crush want to go on the biggest roller coaster.')
                    print ('You are scared of roller coasters and do not want to go on.')
                    c= int(input('Do you tell them?(1- yes 2-no): '))

                    if c == 1:
                        print ('Your crush understood and asked you on another date.')
                        age = age + 2
                    else:
                        print ('You passed out on the roller coaster and had to go home.')
                        age = age - 3
                else:
                    print ('You go with your best friend and it is time for lunch')
                    lunch = int(input('Will you have a hot dog or cotton candy?(1-  Hot Dog 2- Cotton Candy): '))
                    if lunch==1:
                        print ('You got food poisoning and had to go home')
                        age = age - 7
                    else:
                        print ('You and your best friend had an amazing day at the carnival!')
                        age = age + 2
                print('')

            #Desicion
            if i == 15:
                print ('On the first day of grade 10 you get computer science on your schedule.')
                course = int(input('Do you keep the course or do you drop it?(1- keep it 2- drop it): '))
                if course == 1:
                    print ('You got a 95% in the course!')
                else:
                    print ('You got French as your new elective and failed.')
                print('')

            #Desicion
            if i == 18:
                print('You just graduated high school!')
                school = input('What would you like to go to school to become?: ')
                if y == 1:
                    print ('Your old friend from vacation is the head of the school you want to go to.')
                    time.sleep(1)
                    print ('You get into your top school and get a scholarship!')
                    age = age +3
                if y != 1:
                    print ('You could not afford the tuition so you had to pick a different school.')
                    time.sleep(1)
                    print ('Congratulations! you got into the second school of your choice!')
                    age = age -5
                print('')

            #Print
            if i == 21:
                print ('You bought your first house!')
                print ('')

            #Print
            if i == 24:
                print ('You graduated school and are on the track to becoming a',school)
                print ('')

            #Desicion
            if i == 25:
                print ('You got 2 job offers but one of them is outside of',location)
                live = int(input('What job will you take?(1- Move Away 2- Stay Home): '))
                if live == 1:
                    print ('You moved to California and recieved a pay raise!')
                    age = age +3
                else:
                    print ('You got fired from your job and had to move back into your parents basement')
                    age = age -7
                print ('')

            #Desicion
            if i == 30:
                print ('You have two admirers. Michelle Peters and Angelo Attia')
                date = int(input('Who will you choose?(1- Michelle 2- Angelo): '))
                if date == 1:
                    print ('You go on a date with Michelle and she tells you she does not like dogs.')
                    dog = int(input('Do you end the date or you continue and see where it goes.  What do you do?(1- end it 2- continue): '))
                    if dog == 1:
                        print ('You ended your date with Michelle and went home')
                        age = age -6
                    else:
                        print ('You continue your date and find out she likes dogs she just likes cats betetr.')
                        print ('You go on many more dates with Michelle and end up meeting her cat')
                        spouse = 'Michelle'
                else:
                    print ('You go on a date with Angelo but he is shorter than you.')
                    stay = int(input('Do you end or continue your date with him? (1- end it 2- continue): '))
                    if stay == 1:
                        print ('You left the date and found out he is a millionaire')
                        age = age - 5
                    else:
                        print ('You had a good time with him and found out he does a lot of charity work and is rich')
                        spouse = 'Angelo'
                print ('')

            #Desicion
            if i == 35 and spouse != '':
                print ('You and ',spouse,' got married!')
                print ('')
            if i == 35 and spouse=='':
                print ('You met someone named Riley Brancatis')
                print ('You and Riley got married after 3 dates!')
                spouse = 'Riley'
                print('')

            #Desicion
            if i == 36:
                print ('You and ',spouse,'bought a house together!')
                pregnant = int(input('Would you like to have a baby?(1- yes 2- no): '))
                if pregnant == 1:
                    print ('Congratulations! You are pregnant!')
                else:
                    print ('Your spouse',spouse,' tells you they want a baby')
                    print ('You found out that you can not have a baby due to complications')
                print ('')
            #Desicion
            if i == 37 and pregnant == 1:
                print ('You and ',spouse,' have a baby girl!')
                baby = input('What will you name her?: ')
                time.sleep(1)
                print ('You had a beautiful baby girl named',baby,'!')
                print('')
            if i == 37 and pregnant==2:
                print ('You got a dog!')
                baby= input('What will you name your dog?: ')
                time.sleep(1)
                print ('You have a beautiful dog named ',baby)
                print ('')

            #Desicion
            if i == 45:
                print ('You and your family have the chance to go on a mystery vacation!')
                vacay = int(input('Will you choose vacation 1 or vacation 2?: '))
                print ('You get the the airport and your tickets say you are going to...')
                time.sleep(2)
                if vacay == 1:
                    print('Maui, Hawaii!')
                    print ('You got a tan and were very relaxed on your first family vacation')
                else:
                    print ('Africa')
                    print ('You did lots of charity work with your family and felt great afterwards')
                print ('')

            #Decision
            if i == 50 and pregnant == 1:
                print (baby,'and',spouse,'are throwing you a surprise party and you know about it.')
                d = int(input('Do you tell them that you know?(1- Tell them 2- Do not tell them): '))
                if d ==1:
                    print ('They tell you about it before you get the chance to tell them you know.')
                else:
                    print ('You act surprised and have an amazing party!')
                print ('')

            if i == 50 and pregnant== 2:
                print(spouse, 'is throwing you a surprise party and you know about it.')
                d = int(input('Do you tell them that you know?(1- Tell them 2- Do not tell them): '))
                if d == 1:
                    print('They tell you about it before you get the chance to tell them you know.')
                else:
                    print('You act fake surprised and have an amazing party!')
                print('')

            #print
            if i == 53 and pregnant == 2:
                print (baby,'passed away')
                print ('')

            #Decision
            if i == 55 and pregnant==1:
                print (baby,'asks you to pay her university tuition')
                pay = int(input('Will you pay it for her?(1- yes 2- no): '))
                if pay == 1:
                    print (baby,'thanked you and told you she loved you')
                else:
                    print (baby,'got a job and learned to be more independent')
                print ('')
            #Print
            if i == 57:
                print('You got promoted at work and got a huge pay raise!')
                print ('')

            #Decision
            if i == 63:
                print ('Your father passes away and leaves you a great deal of money')
                take = int(input('Will you keep the money or donate some of it to charity?(1- keep 2- donate): '))
                if take == 2:
                    print ('You donated to the charity of you choice and felt amazing afterwards')
                if take == 1:
                    print ('You were greedy and lost the money as your mother took it back')
                print ('')

            #Print
            if i == 65:
                print ('You retired!')
                print ('')

            #Decision
            if i == 69:
                print (spouse, 'wants to go on vacation')
                vac = int(input('Where will you go?(1- Miami, Florida 2- Cancun, Mexico): '))
                if vac == 1:
                    print ('You go to the beach and forgot your sunscreen.')
                    h = int(input('Do you stay at the beach or go home to get the sunscreen? (1- stay 2- go home): '))
                    if h == 1:
                        print ('You got a sunburn and had to stay inside for the rest of vacation')
                        i = i - 5
                    if h == 2:
                        print ('You went back to the beach and had a great rest of your vacation')
                if vac == 2:
                    print ('You went to the beach and found a diamond ring')
                    h = int(input('Do you keep the ring or bring it to the life guard?(1- keep it 2- turn it in):  '))
                    if h == 1:
                        print ('You got charged for theft because the owner saw you take it')
                    if h == 2:
                        print ('The owner of the ring gave you $1000 as a reward')
                print ('')

            #Decision
            if i == 74:
                print ('You have been told you have a rare blood disease')
                death = int(input('You have been offered to partake in a clinical trial.  Will you do it?(1- yes 2- no): '))
                if death == 1:
                    print ('You got very ill from the trial')
                    age = age - 10
                else:
                    print ('You went on normal medication and got healthy again')
                    age = age + 3
                print('')

            #print
            if i == 77:
                print ('You went to the doctor today')
                print ('')

            #Decision
            if i == 81:
                home = int(input('Do you want to go in to a retirement home?(1- yes 2- no): '))
                if home == 1:
                    print('You went into a retirement home and made new friends')
                if home == 2:
                    print ('You stayed living at home and you got a cat')
                print ('')

            #Print
            if i == 86:
                print(spouse,'has passed away')
                print ('')

            #Decision
            if i == 93:
                doc = int(input('Do you want to go to the doctors?(1- yes 2- no): '))
                if doc == 1:
                    print ('You had a check up and got vitamin E pills')
                if doc == 2:
                    print ('You got the flu')
                    age = age - 5
                print ('')

            #Print
            if i == 100:
                print ('You celebrate your 100th birthday!')

            #Desicion
            if i == 103:
                print ('You went swimming and saw an old friend')
                c = int(input('Do you go say hi to them?(1- yes 2- no): '))
                if c == 1:
                    print ('You said hi to her and she told you about a new medication she takes to help stay awake')
                    t = int(input('She offers it to you.  Will you try it?(1- yes 2- no): '))
                    if t == 1:
                        print ('You took it and were fined for driving under the influence')
                    if t == 2:
                        print ('You say no and did not talk to her again')
                if c == 2:
                    print ('You tried to avoid her and she saw you and went over to say hello')
                print('')

            #Decision
            if i == 110:
                print ('You were invited to a birthday party by one of your oldest friends.')
                u = int(input('Will you go?(1- yes 2- no): '))
                if u == 1:
                    print ('You went to the party and had a good time')
                if u == 2:
                    print ('Your friend forced you to go and you had a good time')
                print ('')

            if i == 112:
                print ('You won the lottery')

            #Counter
            i = i + 1