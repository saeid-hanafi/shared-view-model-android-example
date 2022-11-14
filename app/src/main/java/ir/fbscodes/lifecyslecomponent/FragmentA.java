package ir.fbscodes.lifecyslecomponent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

public class FragmentA extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        // By Shared ViewModel
        MyViewModel myViewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);

        EditText firstName = view.findViewById(R.id.firstname);
        EditText LastName = view.findViewById(R.id.lastname);

        // By Shared ViewModel
        firstName.setText(myViewModel.getFirstName());
        LastName.setText(myViewModel.getLastName());

        Button subBtn = view.findViewById(R.id.sub);
        subBtn.setOnClickListener(v -> {
            if (firstName.length() < 1) {
                firstName.setError("is empty!");
            }else if (LastName.length() < 1) {
                LastName.setError("is Empty!");
            }else{
                // By Bundle Method
//                Bundle bundle = new Bundle();
//                bundle.putString("first", firstName.getText().toString());
//                bundle.putString("last", LastName.getText().toString());
//                Navigation.findNavController(view).navigate(R.id.action_fragmentA_to_fragmentB, bundle);

                // By Shared ViewModel
                myViewModel.setFirstName(firstName.getText().toString());
                myViewModel.setLastName(LastName.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_fragmentA_to_fragmentB);
            }
        });
        return view;
    }
}
